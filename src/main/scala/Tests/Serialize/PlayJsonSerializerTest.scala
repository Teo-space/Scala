package Tests.Serialize

import play.api.libs.json.*

object PlayJsonSerializerTest {
	def Run(): Unit = {
		val resident : Resident = Resident("John", 21, None);

		val residentJsValue : JsValue  = Json.toJson(resident);
		val residentJsonString = residentJsValue.toString;
		println(f"residentJsonString: \n ${residentJsonString}")

		val residentJsValueFromJson : JsValue = Json.parse(residentJsonString);
		val residentFromJson: JsResult[Resident] = Json.fromJson[Resident](residentJsValueFromJson)

		residentFromJson match {
			case JsSuccess(resident: Resident, path: JsPath) => println("Name: " + resident.name)
			case e@JsError(x) => println("Errors: " + JsError.toJson(e).toString())
		}

		residentJsValueFromJson.validate[Resident] match {
			case JsSuccess(x, path) => println(x)
			case JsError(errors) => println(errors)
		}

		residentJsValueFromJson.validate[People] match {
			case JsSuccess(x, path) => println(x)
			//case JsError(errors) => println(errors)
			case JsError(errors) => errors
				.flatMap((path, jsonValidationErrors) => jsonValidationErrors
					.flatMap(jsonValidationError => jsonValidationError.messages
						.map(message => (path, message) )))
				.foreach((path, message) => println(f"path: '${path}'. Error: '${message}'"))
		}
	}
}

case class Resident(name: String, age: Int, role: Option[String])

object Resident
{
	implicit val residentReads: Reads[Resident] = Json.reads[Resident]
	implicit val residentWrites: OWrites[Resident] = Json.writes[Resident]
}

case class People(FirstName: String)
object People
{
	implicit val residentReads: Reads[People] = Json.reads[People]
	implicit val residentWrites: OWrites[People] = Json.writes[People]
}