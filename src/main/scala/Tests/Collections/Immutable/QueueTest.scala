package Tests.Collections.Immutable

import scala.collection.immutable.*;

object QueueTest {
	def Run(): Unit ={
		var queue: Queue[String] = Queue();

		println(queue)
		queue = queue.enqueue("a")
		println(queue)
		queue = queue.enqueueAll(List("b", "c"))

		println(queue)
		println(queue.dequeue)
		println(queue)
		println(queue.dequeue)
		println(queue)
		println(queue.dequeue)
		println(queue)


	}
}
