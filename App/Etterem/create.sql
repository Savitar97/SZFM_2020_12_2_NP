
    create table hibernate_sequence (
       next_val bigint
    ) engine=InnoDB

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    insert into hibernate_sequence values ( 1 )

    create table IngredientDataModel (
       id bigint not null,
        amount bigint not null,
        name varchar(255) not null,
        unit varchar(255) not null,
        primary key (id)
    ) engine=InnoDB

    create table MealDataModel (
       id bigint not null,
        name varchar(255) not null,
        price bigint not null,
        menu_id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table MealOrderDataModel (
       amount bigint not null,
        order_id bigint not null,
        meal_id bigint not null,
        primary key (meal_id, order_id)
    ) engine=InnoDB

    create table MenuDataModel (
       id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table OrderDataModel (
       id bigint not null,
        address varchar(255) not null,
        comment varchar(255),
        method_of_payment varchar(255) not null,
        name varchar(255) not null,
        phone_number bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table RecipeDataModel (
       amount bigint not null,
        ingredient_id bigint not null,
        meal_id bigint not null,
        primary key (ingredient_id, meal_id)
    ) engine=InnoDB

    create table ReservationDataModel (
       id bigint not null,
        amount_of_people bigint,
        date datetime(6) not null,
        name varchar(255) not null,
        phone_number bigint not null,
        primary key (id)
    ) engine=InnoDB

    alter table MealDataModel 
       add constraint FKf5xyu3s2l9p9llw6knj3fnrrf 
       foreign key (menu_id) 
       references MenuDataModel (id)

    alter table MealOrderDataModel 
       add constraint FKkoqdi62c187fbgni46lp3bwv4 
       foreign key (order_id) 
       references OrderDataModel (id)

    alter table MealOrderDataModel 
       add constraint FKpoco7atmp072clnjbh4uvqvvo 
       foreign key (meal_id) 
       references MealDataModel (id)

    alter table RecipeDataModel 
       add constraint FKiyaf14yno7mbiw2aiiv72qyai 
       foreign key (ingredient_id) 
       references IngredientDataModel (id)

    alter table RecipeDataModel 
       add constraint FKjhbxnff6cwmu1v1bqwgluotl0 
       foreign key (meal_id) 
       references MealDataModel (id)
