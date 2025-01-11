import Tests.*
import Tests.Monads.*
import Tests.Cycles.*
import Tests.Strings.*
import Tests.OOP.*
import Tests.Collections.Immutable.*
import Tests.Collections.Mutable.*
import Tests.DataTypes.*
import Tests.Serialize.*
import Tests.Concurrent.*

object main extends App
{
	//CaseClass.Run();
	//Class.Run();
	//StringInterpolation.Run();
	//WhileCycleTest.Run();
	//ForCycleTest.Run();
	//PatternMatching.Run();

	//DateTimeJava.Run();
	//DateTimeScala.Run();
	//UlidScala.Run();

	if(true){
		//CollectionMethods.Run();

		//QueueTest.Run();
		//ListTest.Run();
		//VectorTest.Run();
		//SetTest.Run();
		//SortedSetTest.Run();
		//MapTest.Run();
		//TreeMapTest.Run();

		//ArrayBufferTest.Run();
		//ListBufferTest.Run();
		//StringBuilderTest.Run();
		//ArrayDequeTest.Run();
		//QueueMutableTest.Run();
		//MapMutableTest.Run();
	}

	//PlayJsonSerializerTest.Run();

	//MonadsUsageSample.Run();
	//OptionTest.Run();
	//TryTest.Run();
	//EitherTest.Run();

	FutureTest_OnComplete.Run();
	FutureTest_For.Run();

}
