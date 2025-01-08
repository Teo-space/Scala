package Tests.Collections.Mutable

import scala.collection.mutable.ArrayDeque

object ArrayDequeTest {
	def Run(): Unit ={
		val arrayDeque: ArrayDeque[Int] = new ArrayDeque;
		arrayDeque.prepend(1);
		arrayDeque.prepend(2);
		arrayDeque.prepend(3);
		arrayDeque.append(3)
		arrayDeque.append(2)
		arrayDeque.append(1)

		println(arrayDeque)

		println(arrayDeque.remove(0))
		println(arrayDeque)
	}
}
