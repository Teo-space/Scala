package Tests.Concurrent

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

object FutureTest_OnComplete {

	given ExecutionContext = ExecutionContext.global

	def Run(): Unit = {
		val f1: Future[Int] = Future {
			println("Future Start");
			Thread.sleep(700);
			1;
		}

		f1.onComplete({
			case Success(value) => {
				println(f"Success! Value: ${value}")
			};
			case Failure(ex) => println(f"Failure! Error: ${ex}");
		})

		Thread.sleep(1000);
	}
	
}
