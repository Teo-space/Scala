package Tests.Collections

case class Maker(Value: Int, Name: String);

case class Detail(MakerId: Int, MakerName: String, DetailId: Int, DetailName: String);

case class MakerGroup(Maker: Maker, Details: List[Detail]);

object CollectionMethods
{
	def Run(): Unit =
	{
		val details = List(
			Detail(1, "BMW", 12345, "Spot"),
			Detail(1, "BMW", 12351, "Spot2"),
			Detail(2, "AUDI", 32134, "Spot"),
			Detail(2, "AUDI", 32134, "Motor"),
		);

		println(s"details.exists '${details.exists(d => d.DetailId == 12345)}'");
		println(s"details.filter '${details.filter(d => d.DetailId == 12345)}'");
		println(s"details.find DetailName '${details.find(d => d.DetailId == 12345).get.DetailName}'");
		println(s"details.map.distinct DetailName '${details.map(x => x.DetailName).distinct}'");
		println(s"details.map.distinct Maker '${details.map(x => Maker(x.MakerId, x.MakerName)).distinct}'");

		val grouppedByMaker = 		details
			.groupBy(x => Maker(x.MakerId, x.MakerName))
			.map((key, values) => MakerGroup(key, values));

		println(grouppedByMaker);

		val list = List(1, 2, 3, 4, 5)
		list.foreach(num => println(num))

		val lists = List(List(1, 2, 3), List(3, 4, 5), List(5, 6, 7))
		println(lists)
		println(lists.flatMap(l => l))

	}
}

