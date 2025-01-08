package Tests.Collections.Mutable

import scala.collection.mutable.ArrayBuffer

object ArrayBufferTest {
	def Run(): Unit = {
		val names = ArrayBuffer[String]()

		val ints = ArrayBuffer[Int]()
		ints += 1
		ints += 2
		ints += 3
		ints += 4

		println(ints)
		println(ints.max)
		println(ints.length)
		println(ints.filter(x => x > 2))

		println(ints.map(x => f"x: $x").toArray())
		println(ints.map(x => f"x: $x").toList)
		println(ints.map(x => f"x: $x").toSet)
		println(ints.map(x => f"x: $x").toVector)
		println(ints.map(x => f"x: $x").toSeq)
		println(ints.map(x => f"x: $x").toStream)

		println(f"ArrayBuffer test append")
		var test: ArrayBuffer[Int] = ArrayBuffer()
		Globals.Time {
			for (i <- 1 to 100_000) {
				test.append(i)
			}
		}

		println(f"test.length: ${test.length}")
	}
}
