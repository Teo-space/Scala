package Tests.DataTypes

import com.github.nscala_time.time.Imports.*

object DateTimeScala {
	def Run(): Unit = {
		println("DateTimeScala")

		println(s"DateTime.now : ${DateTime.now()}")
		println(s"DateTime.lastDay : ${DateTime.lastDay()}")
		println(s"DateTime.nextDay : ${DateTime.nextDay()}")
		println(s"DateTime.now().date : ${DateTime.now().date}")

		println(s"DateTime.millis : ${DateTime.now().millis}")
		println(s"DateTime.getMillis : ${DateTime.now().getMillis}")
		println()
	}
}