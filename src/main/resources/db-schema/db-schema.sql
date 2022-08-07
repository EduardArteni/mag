CREATE TABLE  public."user"
(
    id serial NOT NULL,
    username character varying UNIQUE NOT NULL,
    password character varying  NOT NULL,
    CONSTRAINT user_pkey PRIMARY KEY (id)
);


CREATE TABLE public.product
(
    id serial NOT NULL,
    name character varying NOT NULL,
    description text NOT NULL,
    "SKU" character varying NOT NULL,
    category character varying NOT NULL,
    price double precision NOT NULL,
    created_at timestamp without time zone NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE public.cart_item
(
    id serial NOT NULL,
    user_id integer NOT NULL,
    product_id integer NOT NULL,
    quantity integer NOT NULL,
    total double precision NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE public.order_details
(
    id serial NOT NULL,
    user_id integer NOT NULL,
    total double precision NOT NULL,
    created_at time without time zone NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE public.order_items
(
    id serial NOT NULL,
    order_id integer NOT NULL,
    product_id integer NOT NULL,
    created_at time without time zone NOT NULL,
    PRIMARY KEY (id)
);
