package Tests.Concurrent

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

object FutureTest_For
{
	given ExecutionContext = ExecutionContext.global

	def Run() : Unit =
	{
		def userIdByEmail(email: String): Future[Int] =  Future {
			Thread.sleep(200)
			1
		}

		def ticketIdsByUser(userId: Int): Future[Seq[Int]] =  Future {
			Thread.sleep(200)
			List(1, 2, 3, 4, 5)
		}

		val count: Future[Int] = for{
			userId <- userIdByEmail("test@gmail.com")
			tickets <- ticketIdsByUser(userId)
		} yield  tickets.length

		Thread.sleep(500);

		println(f"Success! count: ${count}")
	}
}
