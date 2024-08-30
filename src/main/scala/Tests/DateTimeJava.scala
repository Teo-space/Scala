package Tests

import java.time.{Instant, LocalDate, LocalDateTime, LocalTime, ZonedDateTime}

object DateTimeJava {
	def Run(): Unit = {
		println(s"DateTimeJava")
		println(s"LocalDate : ${LocalDate.now}")
		println(s"LocalTime : ${LocalTime.now}")
		println(s"LocalDateTime : ${LocalDateTime.now}")
		println(s"Instant : ${Instant.now}")
		println(s"ZonedDateTime : ${ZonedDateTime.now}")

		println(s"Instant.now.getEpochSecond : ${Instant.now.getEpochSecond}")
		println()

	}
}