-- added creared_date column to users table
ALTER TABLE public."user"
ADD COLUMN created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

-- add some test data
INSERT INTO public.product(
	name, description, "SKU", category, price, created_at)
	VALUES ('AUTO-JUNIT-TESTS-TV', 'TV Samsung', 'AUTO-JUNIT-TESTS-TV-SAMSUNG-GEN1', 'AUTO-JUNIT-TESTS-ELECTRO', 1000, now());

-- set default value for product created date
	ALTER TABLE public.product ALTER COLUMN created_at SET DEFAULT CURRENT_TIMESTAMP;

	-- add some more test data
    INSERT INTO public.product(
    	name, description, "SKU", category, price)
    	VALUES ('AUTO-JUNIT-TESTS-TV', 'TV LG', 'AUTO-JUNIT-TESTS-TV-LG-GEN101', 'AUTO-JUNIT-TESTS-ELECTRO', 2000);

-- adjusted the names for testing data
UPDATE public.product SET name='AUTO-JUNIT-TESTS-TV' WHERE category = 'AUTO-JUNIT-TESTS-ELECTRO';


CREATE TABLE IF NOT EXISTS public.order_items
(
    id serial NOT NULL,
    order_id integer NOT NULL,
    product_id integer NOT NULL,
    quantity integer NOT NULL,
    total double precision NOT NULL,
    CONSTRAINT order_items_pkey PRIMARY KEY (id)
)


CREATE TABLE IF NOT EXISTS public."CARD_PAYMENT"
(
    id serial NOT NULL,
    "card_Type" character varying NOT NULL,
    "card_Number" character varying NOT NULL,
    "transaction_Amount" double precision NOT NULL,
    "card_Holder_Name" character varying NOT NULL,
    "exp_Date" date NOT NULL,
    "CV2" character varying NOT NULL,
    CONSTRAINT "CARD_PAYMENT_pkey" PRIMARY KEY (id)
)

INSERT INTO public."CARD_PAYMENT"(
	"card_Type", "card_Number", "transaction_Amount", "card_Holder_Name", "exp_Date", "CV2")
	VALUES ('VISA', '4111111111111111', 10, 'Teodor Arteni', '01-01-2024', '123');

DROP TABLE IF EXISTS public.order_details;

CREATE TABLE IF NOT EXISTS public.order_details
(
    id serial NOT NULL,
    user_id integer NOT NULL,
    total double precision NOT NULL,
    created_at TIMESTAMP without time zone NOT NULL,
    CONSTRAINT order_details_pkey PRIMARY KEY (id)
)

-- corrected the table name, it must be plural: users
ALTER TABLE public.user RENAME TO users;

