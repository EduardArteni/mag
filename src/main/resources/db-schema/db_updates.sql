-- added creared_date column to users table
ALTER TABLE public."user"
ADD COLUMN created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

-- add some test data
INSERT INTO public.product(
	name, description, "SKU", category, price, created_at)
	VALUES ('TV', 'TV Samsung', 'TVSMSNG-GEN1', 'ELECTRO', 1000, now());