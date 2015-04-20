# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "CITIES" ("ID" SERIAL NOT NULL PRIMARY KEY,"NAME" VARCHAR(254) DEFAULT '' NOT NULL,"DESCRIPTION" VARCHAR(254) DEFAULT '' NOT NULL,"COUNTRY_ID" INTEGER NOT NULL);
create table "COUNTRIES" ("ID" SERIAL NOT NULL PRIMARY KEY,"NAME" VARCHAR(254) DEFAULT '' NOT NULL);
create table "CommitTable" ("ID" SERIAL NOT NULL PRIMARY KEY,"NAME" VARCHAR(254) DEFAULT '' NOT NULL,"COMMENTS" VARCHAR(254) DEFAULT '' NOT NULL);
alter table "CITIES" add constraint "CITY_FK_COUNTRY_ID" foreign key("COUNTRY_ID") references "COUNTRIES"("ID") on update NO ACTION on delete NO ACTION;

# --- !Downs

alter table "CITIES" drop constraint "CITY_FK_COUNTRY_ID";
drop table "CommitTable";
drop table "COUNTRIES";
drop table "CITIES";

