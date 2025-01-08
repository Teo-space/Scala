package Tests.Collections.Mutable

import scala.collection.mutable

object QueueMutableTest {
	def Run(): Unit ={
		val queue: mutable.Queue[String] = mutable.Queue();
		queue += "a"
		queue ++= List("b", "c")

		println(queue)
		println(queue.dequeue)
		println(queue)
		println(queue.dequeue)
		println(queue)
		println(queue.dequeue)
		println(queue)


	}
}