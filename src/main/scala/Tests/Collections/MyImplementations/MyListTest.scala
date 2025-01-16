package Tests.Collections.MyImplementations

import scala.annotation.tailrec
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

		println("myList.Take(10)")
		println(myList.Take(10).ToString())
		myList.Take(10).Take(10).ForEach(println)

		//myList.Skip(999_990).ForEach(println)
		//myList.Skip(999_990).Reverse().ForEach(println)

/*
		println("myList.Skip(5).Take(10)")
		//myList.Skip(5).Take(10).ForEach(println)

		println(myList.Take(10).ToString())

		Globals.Time {
			myList.Take(10).Select(x => x.toString)
		}

		println("myList.fold")
		Globals.Time {
			val r = myList.Fold(0)((a, b) => a + b)
			println(r)
		}

		println("foldList")
		var foldList: MyList[Int] = MyList.Empty().Add(0).Add(1).Add(2).Add(3);

		println(foldList.Take(10).Fold(0)((a, b) => a + b))*/
	}
}

enum MyList[TElement]
{
	case Empty();
	private case Pair(head: TElement, tail: MyList[TElement]);

	def IsEmpty: Boolean = this match
		case Empty() => true
		case pair: Pair[TElement] => false

	def IsNotEmpty: Boolean = this match
		case Empty() => false
		case pair: Pair[TElement] => true

	def Add(element : TElement) : MyList[TElement] = Pair(element, this)

	final def Reverse() : MyList[TElement] = {
		var result: MyList[TElement] = Empty();

		this.ForEach(element => {
			result = result.Add(element)
		})

		result
	}

	final def ForEach(func: TElement => Unit) : Unit = {
		this match {
			case Empty() => Empty()
			case pair: Pair[TElement] => {
				var current: MyList[TElement] = pair;

				while (current.IsNotEmpty) {
					current match {
						case Empty() => ;
						case currentPair: Pair[TElement] => {
							func(currentPair.head)
							current = currentPair.tail
						}
					}
				}
			}
		}
	}

	@tailrec final def ForEachReversed(func: TElement => Unit): Unit = {
		this match {
			case Empty() => Empty()
			case pair: Pair[TElement] => {
				func(pair.head)
				pair.tail.ForEachReversed(func)
			}
		}
	}

	@tailrec final def Fold[TResult](default: TResult)(accumulator: (element: TElement, accumulated: TResult) => TResult): TResult = {
		this match
			case Empty() => default
			case Pair(head, tail) => tail.Fold(accumulator(head, default))(accumulator)
	}


	final def Select[TResult](f: TElement => TResult): MyList[TResult] =
		Fold(Empty())((element: TElement, accumulated: MyList[TResult]) => accumulated.Add(f(element)))
		/*this match {
			case Empty() => Empty()
			case Pair(head, tail) => {
				//Pair(f(head), tail.Select(f))
				val mappedHead = f(head)
				val mappedTail = tail.Select(f)
				Pair(mappedHead, mappedTail)
			}
		}*/

	def Skip(n: Int): MyList[TElement] = {
		if (n < 0) Empty()
		else if(n == 0){
			this
		}

		var counter: Int = 0;
		var result: MyList[TElement] = Empty();

		this.ForEachReversed(element => {
			if(counter == n){
				result = result.Add(element)
			}
			else counter += 1;
		})

		result
	}

	def Take(n: Int) : MyList[TElement] = {
		if (n <= 0) Empty()
		else this match {
			case Empty() => Empty()
			case pair: Pair[TElement] => {
				var result: MyList[TElement] = Empty();
				var counter: Int = 0;
				var current: MyList[TElement] = pair;

				while (counter < n && current.IsNotEmpty) {
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


	def ToString() : String = {
		this match {
			case Empty() => "MyList()"
			case pair: Pair[TElement] =>
			{
				val stringBuilder: StringBuilder = StringBuilder()

				stringBuilder.append("MyList");
				stringBuilder.append("(");

				stringBuilder.append(pair.Fold(f"${pair.head}") ((element: TElement, accumulated: String) => {
					accumulated + f", ${element}"
				}))

				stringBuilder.append(")")

				stringBuilder.toString()
			}
		}
	}
}


