package Tests.Collections.Mutable

import scala.collection.mutable.*

object ListBufferTest {
	def Run(): Unit = {

		val names: ListBuffer[String] = ListBuffer("Joel", "Chris", "Ed")

		var ints: ListBuffer[Int] = ListBuffer(1, 2, 3)

		ints.addOne(4);
		//ints = 0 +: ints;
		//ints = ints :+ 4;

		println(ints)

		println(f"Max: ${ints.max}")
		println(f"Length: ${ints.length}")
		println(f"filter: ${ints.filter(x => x > 2)}")

		println(ints.map(x => f"x: $x").toArray())
		println(ints.map(x => f"x: $x").toList)
		println(ints.map(x => f"x: $x").toSet)
		println(ints.map(x => f"x: $x").toVector)
		println(ints.map(x => f"x: $x").toSeq)

		println(f"ListBuffer testAppend")
		val testAppend: ListBuffer[Int] = ListBuffer()
		Globals.Time {
			for(i <- 1 to 100_000){
				testAppend.append(i)
			}
		}

		println(f"ListBuffer testPrepend")
		var testPrepend: ListBuffer[Int] = ListBuffer()
		Globals.Time {
			for (i <- 1 to 100_000) {
				testPrepend.prepend(i)
			}
		}
	}
}
