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