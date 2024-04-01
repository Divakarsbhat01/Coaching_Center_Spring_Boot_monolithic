in order to make this application work
Mongo DB
    create a database in mongo db with name users_sb
    port: 27017
    create collection with name user_details
    data has to be in format:
        user_name:"ram@gmail.com"
        user_password: "$2b$12$kI4W/FRwZgLlhHECHict0OvbiagU8WKADnXLyezBzjbfMbu517BVm"
        user_role:"admin"
        user_id:1
    create collection with name user_id_counter
    data has to be in format:
        user_id_counter:6
        counter_name:"user_id_counter"
MysqlDB
    create a databases in mysql db with name coaching_center_springboot_monolithic
    port: 3306

Commands to run:
    java min version 17 and jdk has to be installed in the machine
    go to root folder of this project after creating databases according to instructions
    open command prompt and use command : java -jar target/coacen_mono-0.0.1-SNAPSHOT.jar
