create table kullanicilar(
	id serial primary key,
	kullanici_adi varchar(20),
	sifre varchar(16) not null,
	sehir varchar(30),
	yas int,
	cinsiyet bool,
	sef bool default false
);

create table yetkililer(
	id int primary key references kullanicilar(id)
);

create table yorum_puan(
	id serial primary key,
	tur varchar(40),
	yemek_id int,
	yorum varchar(1000),
	puan int,
	kullanici int references kullanicilar(id)
);

create table ana_yemekler(
	id serial primary key,
	yemek_adi varchar(30),
	tarif text,
	malzemeler text,
	kac_kisilik int,
	hazirlama_sure int,
	pisirme_sure int,
	sef int references kullanicilar(id)
);

create table atistirmalik(
	id serial primary key,
	yemek_adi varchar(40),
	tarif text,
	malzemeler text,
	kac_kisilik int,
	hazirlama_sure int,
	pisirme_sure int,
	sef int references kullanicilar(id)
);

create table salatalar(
	id serial primary key,
	yemek_adi varchar(40),
	tarif text,
	malzemeler text,
	kac_kisilik int,
	hazirlama_sure int,
	pisirme_sure int,
	sef int references kullanicilar(id)
);

create table tatlilar(
	id serial primary key,
	yemek_adi varchar(40),
	tarif text,
	malzemeler text,
	kac_kisilik int,
	hazirlama_sure int,
	pisirme_sure int,
	sef int references kullanicilar(id)
);

create table icecekler(
	id serial primary key,
	yemek_adi varchar(40),
	tarif text,
	malzemeler text,
	kac_kisilik int,
	hazirlama_sure int,
	pisirme_sure int,
	sef int references kullanicilar(id)
);

create table deniz_urunleri(
	id serial primary key,
	yemek_adi varchar(40),
	tarif text,
	malzemeler text,
	kac_kisilik int,
	hazirlama_sure int,
	pisirme_sure int,
	sef int references kullanicilar(id)
);

create table yoreseller(
	id int primary key references ana_yemekler(id),
	yore varchar(40)	
);

create table dosya(
    id serial primary key,
    dosya_ad varchar(100),
    dosya_yol varchar(300),
    dosya_tip varchar(100)
);