// Körs när sidan laddats klart
window.onload = function () {
    console.log("Sidan laddad");
    uppdateraStudentLista(); // Hämtar befintliga studenter direkt
};

// Hämta en student baserat på ID
async function hamtaStudent() {
    const id = document.getElementById("studentId").value;
    const resultDiv = document.getElementById("result");

    if (!id) {
        resultDiv.innerHTML = " Ange ett student-ID.";
        return;
    }

    try {
        const response = await fetch(`/student/${id}`);
        const text = await response.text();
        resultDiv.innerHTML = text;
    } catch (error) {
        resultDiv.innerHTML = " Fel vid hämtning.";
        console.error(error);
    }
}

// Skapa en ny student
async function skapaStudent() {
    const nameInput = document.getElementById("newStudentName");
    const name = nameInput.value.trim();
    const resultDiv = document.getElementById("result");

    if (!name) {
        resultDiv.innerHTML = " Ange ett namn.";
        return;
    }

    try {
        const response = await fetch("/student", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ name: name })
        });

        const text = await response.text();
        resultDiv.innerHTML = text;
        nameInput.value = "";
        uppdateraStudentLista(); // uppdatera listan direkt
    } catch (error) {
        resultDiv.innerHTML = " Fel vid sparning.";
        console.error(error);
    }
}

// Radera en student
async function raderaStudent() {
    const id = document.getElementById("deleteStudentId").value;
    const resultDiv = document.getElementById("result");

    if (!id) {
        resultDiv.innerHTML = " Ange ID att radera.";
        return;
    }

    try {
        const response = await fetch(`/student/${id}`, { method: "DELETE" });
        const text = await response.text();
        resultDiv.innerHTML = text;
        uppdateraStudentLista();
    } catch (error) {
        resultDiv.innerHTML = "❌ Fel vid radering.";
        console.error(error);
    }
}

// Hämta och visa alla studenter i listan
async function uppdateraStudentLista() {
    const listContainer = document.getElementById("studentList");
    const resultDiv = document.getElementById("result");

    try {
        const response = await fetch("/students");
        if (!response.ok) throw new Error("Kunde inte hämta studenter");

        const students = await response.json();
        listContainer.innerHTML = "";

        if (students.length === 0) {
            listContainer.innerHTML = "<li>Inga studenter hittades.</li>";
            return;
        }

        students.forEach(s => {
            const li = document.createElement("li");
            li.innerHTML = `${s.id}: ${s.name} 
                <button onclick="raderaStudentDirekt(${s.id})"></button>`;
            listContainer.appendChild(li);
        });
    } catch (error) {
        resultDiv.innerHTML = " Fel vid hämtning av studentlista.";
        console.error(error);
    }
}

// Radera direkt via knappen i listan
async function raderaStudentDirekt(id) {
    const resultDiv = document.getElementById("result");

    if (!confirm(`Är du säker på att du vill radera student ${id}?`)) return;

    try {
        const response = await fetch(`/student/${id}`, { method: "DELETE" });
        const text = await response.text();
        resultDiv.innerHTML = text;
        uppdateraStudentLista();
    } catch (error) {
        resultDiv.innerHTML = " Fel vid radering.";
        console.error(error);
    }
}
