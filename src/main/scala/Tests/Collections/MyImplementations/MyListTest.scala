package Tests.Collections.MyImplementations

import scala.collection.mutable.StringBuilder

object MyListTest {
	def Run() : Unit = {
		println()
		println(this.getClass.getCanonicalName
			.replace("$", "")
			.replace(this.getClass.getPackageName, "")
			.replace(".", ""))

		var myList: MyList[Int] = MyList.Empty();
		Globals.Time {
			for (i <- 1 to 1000_000) {
				myList = myList.Add(i)
			}
		}

		myList.Take(10).ForEach(println)

		println(myList.Take(10).ToString())


		Globals.Time {
			myList.Take(10).Select(x => x.toString)
		}
	}
}

enum MyList[TElement]
{
	case Empty();
	case Pair(head: TElement, tail: MyList[TElement]);

	def isEmpty: Boolean = this eq Empty
	def isNotEmpty: Boolean = !(this eq Empty)

	def Add(element : TElement) : Pair[TElement] = Pair(element, this)

	def Select[TResult](f: TElement => TResult): MyList[TResult] =
		this match {
			case Empty() => Empty()
			case Pair(head, tail) => Pair(f(head), tail.Select(f))
		}

	def Take(n: Int) : MyList[TElement] = {
		if (n <= 0) Empty()
		else this match {
			case Empty() => Empty()
			case pair: Pair[TElement] => {
				var result: MyList[TElement] = Empty();
				var counter: Int = 0;
				var current: MyList[TElement] = pair;

				while (counter < n && current.isNotEmpty) {
					counter += 1
					current match {
						case Empty() => ;
						case currentPair: Pair[TElement] => {
							result = result.Add(currentPair.head)
							current = currentPair.tail
						}
					}
				}

				result;
			}
		}
	}

	def ForEach(func: TElement => Unit) : Unit = {
		this match {
			case Empty() => Empty()
			case Pair(head, tail) => {
				tail.ForEach(func)
				func(head)
			}
		}
	}

	def ToString() : String = {
		this match {
			case Empty() => "MyList()"
			case pair: Pair[TElement] =>
			{
				val stringBuilder: StringBuilder = StringBuilder()

				stringBuilder.append("MyList");
				stringBuilder.append("(");

				stringBuilder.append(pair.head)

				pair.tail.Take(10).ForEach((x : TElement) => stringBuilder.append(f", ${x}"))

				stringBuilder.append(")")

				stringBuilder.toString()
			}
		}
	}
}


