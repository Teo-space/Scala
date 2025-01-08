package Tests.Monads

object EitherTest {
	def Run(): Unit = {
		val eitherSuccess: Either[String, Int] = Right(100);
		val eitherError: Either[String, Int] = Left("Some Error");

		println(eitherSuccess)
		println(eitherError)

		def printResult(result: Either[String, Int]) : Unit = {
			println(result match {
				case Right(id) => f"Id: ${id}"
				case Left(errorMessage) => f"errorMessage: $errorMessage"
			})
		}

		printResult(eitherSuccess);
		printResult(eitherError);

	}
}
