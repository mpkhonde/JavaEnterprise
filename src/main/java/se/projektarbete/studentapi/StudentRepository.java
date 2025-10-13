package se.projektarbete.studentapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository ger oss automatiskt metoder för att hämta, spara och ta bort studenter.
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
