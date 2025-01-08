package Tests.Monads

import scala.util.{Success, Failure, Try}

object TryTest {
	def Run(): Unit = {
		val tryValueS: Success[String] = Success[String]("Value");

		val result: Try[Int] = toInt1("123");

		println(s"result (isSuccess: ${result.isSuccess}, isFailure: ${result.isFailure})");

		toInt1("321") match {
			case Success(i) => println(i)
			case Failure(s) => println(s"Failed. Reason: $s")
		};

		toInt1("321F") match {
			case Success(i) => println(i)
			case Failure(s) => println(s"Failed. Reason: $s")
		};

	}

	def toInt1(s: String): Try[Int] = Try(Integer.parseInt(s.trim))

	def toInt2(s: String): Try[Int] = Try {
		Integer.parseInt(s.trim)
	}
}
