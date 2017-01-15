--Table: wallet.player_wallet

--DROP TABLE wallet.player_wallet;

CREATE TABLE wallet.player_wallet (
  id         serial NOT NULL,
  player_id  integer NOT NULL,
  balance    double precision,
  /* Keys */
  CONSTRAINT player_wallet_pkey
    PRIMARY KEY (player_id)
) WITH (
    OIDS = FALSE
  );

ALTER TABLE wallet.player_wallet
  OWNER TO postgres;