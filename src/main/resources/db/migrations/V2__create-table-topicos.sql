create table topicos (
                         id bigint not null auto_increment,
                         titulo varchar(255) not null,
                         mensaje text not null,
                         fecha datetime not null,
                         status varchar(50) not null,
                         usuario_id bigint not null,
                         curso varchar(255) not null,
                         activo boolean not null,
                         primary key (id),
                         foreign key (usuario_id) references usuarios(id)
);