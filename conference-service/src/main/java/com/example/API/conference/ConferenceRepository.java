package com.example.API.conference;

import com.example.API.participant.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    @Query("SELECT b FROM Conference b JOIN b.participants a WHERE a.id = :id ORDER BY b.dateAndTimeOfConference ASC")
    List<Conference> findConferenceByParticipant(Long id);



    @Query("SELECT s From Conference s WHERE s.contactEmail = ?1")
    Optional <Conference> findConferenceByEmail(String email);
}
