package UI;

import java.time.LocalDate;

public record MemberDetails(String name, LocalDate birthDate, boolean active, String disciplines) { }
