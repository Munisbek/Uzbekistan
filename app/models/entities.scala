package models



import play.api.db.slick.Config.driver.simple._

case class Region(id: Option[Int],

                name: String,
                population: String,
                center: String)


class  RegionsTable(tag: Tag) extends Table[Region](tag, "REGION") {

  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def name = column[String]("NAME", O.Default(""))

  def population  = column[String]("POPULATION", O.Default(""))

  def center = column[String]("CENTER", O.Default(""))

  def * = (id.?, name, population, center) <> (Region.tupled, Region.unapply _)

}
