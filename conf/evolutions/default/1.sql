# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "CommitTable" ("ID" SERIAL NOT NULL PRIMARY KEY,"NAME" VARCHAR(254) DEFAULT '' NOT NULL,"COMMENTS" VARCHAR(254) DEFAULT '' NOT NULL);
create table "REGION" ("ID" SERIAL NOT NULL PRIMARY KEY,"NAME" VARCHAR(254) DEFAULT '' NOT NULL,"POPULATION" VARCHAR(254) DEFAULT '' NOT NULL,"CENTER" VARCHAR(254) DEFAULT '' NOT NULL);

# --- !Downs

drop table "REGION";
drop table "CommitTable";

