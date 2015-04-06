package models


import play.api.db.slick.Config.driver.simple._

case class Region(id: Option[Int],

                  name: String,
                  population: String,
                  center: String)


class RegionsTable(tag: Tag) extends Table[Region](tag, "REGION") {

  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def name = column[String]("NAME", O.Default(""))

  def population = column[String]("POPULATION", O.Default(""))

  def center = column[String]("CENTER", O.Default(""))

  def * = (id.?, name, population, center) <>(Region.tupled, Region.unapply _)

}

case class Symbol(id: Option[Int],
                   name: String,
                   date: String)

class SymbolTable(tag: Tag) extends Table[Symbol](tag, "SYMBOL") {

  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def name = column[String]("NAME", O.Default(""))

  def date = column[String]("DATE", O.Default(""))

  def * = (id.?, name, date) <> (Symbol.tupled, Symbol.unapply _)

}