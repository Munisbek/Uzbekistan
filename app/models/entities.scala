package models


import play.api.db.slick.Config.driver.simple._

//case class Region(id: Option[Int],
//
//                  name: String,
//                  population: String,
//                  center: String)
//
//
//  class RegionsTable(tag: Tag) extends Table[Region](tag, "REGION") {
//
//  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
//
//  def name = column[String]("NAME", O.Default(""))
//
//  def population = column[String]("POPULATION", O.Default(""))
//
//  def center = column[String]("CENTER", O.Default(""))
//
//  def * = (id.?, name, population, center) <>(Region.tupled, Region.unapply _)
//
//}

case class Commit(id: Option[Int],
                  name: String,
                  comments: String
                 )

class CommitTable(tag: Tag) extends Table[Commit](tag, "CommitTable") {

  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def name = column[String]("NAME", O.Default(""))

  def comments = column[String]("COMMENTS", O.Default(""))


  def * = (id.?, name, comments) <>(Commit.tupled, Commit.unapply _)

}
case class City(id: Option[Int],
                name: String,
                description: String,
                countryId: Int)

case class CityForDisplay(city: City,
                          countryName: String)

case class Country(id: Option[Int],
                   name: String)

class CityTable(tag: Tag) extends Table[City](tag, "CITIES") {

  val countries = TableQuery[CountryTable]

  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def name = column[String]("NAME", O.Default(""))

  def description = column[String]("DESCRIPTION", O.Default(""))

  def countryId = column[Int]("COUNTRY_ID",  O.NotNull)

  def * = (id.?, name, description, countryId) <> (City.tupled, City.unapply _)

  def country = foreignKey("CITY_FK_COUNTRY_ID", countryId, countries)(_.id)


}

class CountryTable(tag: Tag) extends Table[Country](tag, "COUNTRIES") {

  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def name = column[String]("NAME", O.Default(""))

  def * = (id.?, name) <> (Country.tupled, Country.unapply _)

}

