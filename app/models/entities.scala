package models



import play.api.db.slick.Config.driver.simple._

case class Region(id: Option[Int],

                name: String,
                population: String,
                description: String)


class  RegionsTable(tag: Tag) extends Table[Region](tag, "REGION") {

  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def name = column[String]("NAME", O.Default(""))

  def population  = column[String]("POPULATION", O.Default(""))

  def description = column[String]("DESCRIPTION", O.Default(""))

  def * = (id.?, name, population, description) <> (Region.tupled, Region.unapply _)

}
