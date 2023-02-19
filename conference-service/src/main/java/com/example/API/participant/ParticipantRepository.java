package com.example.API.participant;

import com.example.API.conference.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    @Query("SELECT s From Participant s WHERE s.email = ?1")
    Optional<Participant> findParticipantByEmail(String email);

    @Query("SELECT b FROM Conference b JOIN b.participants a WHERE a.id = :id ORDER BY b.dateAndTimeOfConference ASC")
    List<Conference> findConferenceByParticipant(Long id);

    @Query("SELECT b FROM Conference b JOIN b.participants a WHERE a.id = :participantId AND b.conferenceId = :conferenceId")
    Optional<Conference> findConferenceByParticipantAndConferences(Long participantId, Long conferenceId);
}
