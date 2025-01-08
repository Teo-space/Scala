package Tests.DataTypes

import java.time.{Instant, LocalDate, LocalDateTime, LocalTime, ZonedDateTime}

object DateTimeJava {
	def Run(): Unit = {
		println
		println(s"DateTimeJava")
		println(s"LocalDate : ${LocalDate.now}")
		println(s"LocalTime : ${LocalTime.now}")
		println(s"LocalDateTime : ${LocalDateTime.now}")
		println(s"Instant : ${Instant.now}")
		println(s"ZonedDateTime : ${ZonedDateTime.now}")

		println(s"Instant.now.getEpochSecond : ${Instant.now.getEpochSecond}")
		println()
		/*
		val tStart = System.nanoTime()
		Thread.sleep(1000)
		val tEnd = System.nanoTime()

		println(s"Diff : ${tEnd - tStart} ns")
		println(s"Diff : ${(tEnd - tStart) / 1000} ms")
		println(s"Diff : ${(tEnd - tStart) / 1000_000} s")*/

		Globals.Time {
			Thread.sleep(1000)
		}
	}

}