use
furama_resort;

-- TASK1 --

insert into posision(name)
values ("QUẢN LÝ"),
       ("NHÂN VIÊN");

insert into education_degree(name)
values ("TRUNG CẤP"),
       ("CAO ĐẲNG"),
       ("ĐẠI HỌC"),
       ("SAU ĐẠI HỌC");

insert into division(name)
values ("SALE-MARKETING"),
       ("HÀNH CHÍNH"),
       ("PHỤC VỤ"),
       ("QUẢN LÝ");

insert into employee(name, date_of_birth, id_card, salary, phone_number, email, address, posision_id, education_degree_id,
                      division_id)
values ("NGUYỄN VĂN AN", "1970-11-07", "4562317861", 10000000, "0901234121", "ANNGUYEN@GAMIL.COM",
        "295 NGUYỄN TẤT THÀNH, ĐÀ NẴNG", 1, 3, 1),
       ("LÊ VĂN BÌNH", "1997-04-09", "654231234", 70000000, "0934212314", "BINHLV@GMAIL.COM", "22 YÊN BÁI, ĐÀ NẴNG",
        1, 2, 2),
       ("HỒ THỊ YẾN", "1995-12-12", "999231723", 14000000, "0412352315", "THIYEN@GAMIL.COM",
        "K234/11 ĐIỆN BIÊN PHỦ, GIA LAI", 1, 3, 2),
       ("VÕ CÔNG TOẢN", "1980-04-04", "123231365", 17000000, "0374443232", "TOAN0404@GMAIL.COM",
        "77 HOÀNG DIỆU, QUẢNG TRỊ", 1, 4, 4),
       ("NGUYỄN BỈNH PHÁT", "1999-12-09", "454363232", 6000000, "0902341231", "PHATPHAT@GMAIL.COM",
        "43 YÊN BÁI, ĐÀ NẴNG", 2, 1, 1),
       ("KHÚC NGUYỄN AN NGHI", "2000-11-08", "964542311", 7000000, "0978653213", "ANNGHI20@GMAIL.COM",
        "294 NGUYỄN TẤT THÀNH, ĐÀ NẴNG", 2, 2, 3),
       ("NGUYỄN HỮU HÀ", "1993-01-01", "534323231", 8000000, "0941234553", "NHH101@GMAIL.COM",
        "4 NGUYỄN CHÍ THANH, HUẾ", 2, 3, 2),
       ("NGUYỄN HÀ ĐÔNG", "1989-09-03", "234414123", 9000000, "0642123111", "DONGHANGUYEN@GMAIL.COM",
        "111 HÙNG VƯƠNG, HÀ NỘI", 2, 4, 4),
       ("TÒNG HOANG", "1982-09-03", "256781231", 6000000, "0245144444", "HOANGTONG@GMAIL.COM", "213 HÀM NGHI, ĐÀ NẴNG",
        2, 4, 4),
       ("NGUYỄN CÔNG ĐẠO", "1994-01-08", "755434343", 8000000, "0988767111", "NGUYENCONGDAO12@GMAIL.COM",
        "6 HOÀ KHÁNH, ĐỒNG NAI", 2, 3, 2);

insert into customer_type(name)
values ("DIAMOND"),
       ("PLATINIUM"),
       ("GOLD"),
       ("SILVER"),
       ("MEMBER");

insert into customer(name, date_of_birth, gender, id_card, phone_number, email, address, customer_type_id)
values ("NGUYỄN THỊ HÀO", "1970-11-07", 0, "643431213", "0945423362", "THIHAO07@GMAIL.COM", "23 NGUYỄN HOÀNG, ĐÀ NẴNG",
        5),
       ("PHẠM XUÂN DIỆU", "1992-08-08", 1, "865342123", "0954333333", "XUANDIEU92@GMAIL.COM",
        "K77/22 THÁI PHIÊN, QUẢNG TRỊ", 3),
       ("TRƯƠNG ĐÌNH NGHỆ", "1990-02-27", 1, "488645199", "0373213122", "NGHENHAN2702@GAMIL.COM",
        "K323/12 ÔNG ÍCH KHIÊM, VINH", 1),
       ("DƯƠNG VĂN QUAN", "1981-07-08", 1, "543432111", "0490039241", "DUONGQUAN@GMAIL.COM", "K453/12 LÊ LỢI, ĐÀ NẴNG",
        1),
       ("HOÀNG TRẦN NHI NHI", "1995-12-09", 0, "795453345", "0312345678", "NHINHI123@GMAIL.COM",
        "224 LÝ THÁI TỔ, GIA LAI", 4),
       ("TÔN NỮ MỘC CHÂU", "2005-12-06", 0, "732434215", "0988888844", "TONNUCHAU@GMAIL.COM", "37 YÊN THẾ, ĐÀ NẴNG", 4),
       ("NGUYỄN MỸ KIM", "1984-04-08", 0, "856453123", "0912345698", "KIMCUONG84@GMAIL.COM",
        "K123/45 LÊ LỢI, HỒ CHÍ MINH", 1),
       ("NGUYỄN THỊ HÀO", "1999-04-08", 0, "965656433", "0763212345", "HAOHAO99@GMAIL.COM",
        "55 NGUYỄN VĂN LINH, KON TUM", 3),
       ("TRẦN ĐẠI DANH", "1994-07-01", 1, "432341235", "0643343433", "DANHHAI99@GMAIL.COM",
        "24 LÝ THƯỜNG KIỆT, QUẢNG NGÃI", 1),
       ("NGUYỄN TÂM ĐẮC", "1989-07-01", 1, "344343432", "0987654321", "DACTAM@GMAIL.COM", "22 NGÔ QUYỀN, ĐÀ NẴNG", 2);

insert into facility_type(name)
values ("VILLA"),
       ("HOUSE"),
       ("ROOM");

insert into rent_type(name)
values ("YEAR"),
       ("MONTH"),
       ("DAY"),
       ("HOUR");

insert into facility(name, area, cost, max_people, standard_room, description_other_convenience,pool_area,
                    number_of_floors, facility_free, rent_type_id, facility_type_id)
values ("VILLA BEACH FRONT", 25000, 1000000, 10, "VIP", "CÓ HỒ BƠI", 500, 4, NULL, 3, 1),
       ("HOUSE PRINCESS 01", 14000, 5000000, 7, "VIP", "CÓ THÊM BẾP NƯỚNG", 0, 3, NULL, 2, 2),
       ("ROOM TWIN 01", 5000, 1000000, 2, "NORMAL", "CÓ TIVI", 0, 0, "1 XE MÁY,1 XE ĐẠP", 4, 3),
       ("VILLA NO BEACH FRONT", 22000, 9000000, 8, "NORMAL", "CÓ HỒ BƠI", 300, 3, NULL, 3, 1),
       ("HOUSE PRINCESS 02", 10000, 4000000, 5, "NORMAL", "CÓ THÊM BẾP NƯỚNG", 0, 2, NULL, 3, 2),
       ("ROOM TWIN 02", 3000, 900000, 2, "NORMAL", "CÓ TIVI", 0, 0, "1 XE MÁY", 4, 3);

insert into attach_facility(name, cost, unit, status)
values ("KARAOKE", 10000, "GIỜ", "TIỆN NGHI,HIỆN ĐẠI"),
       ("THUÊ XE MÁY", 10000, "CHIẾC", "HỎNG 1 XE"),
       ("THUÊ XE ĐẠP", 20000, "CHIẾC", "TỐT"),
       ("BUFFET BUỔI SÁNG", 15000, "SUẤT", "ĐẦY ĐỦ ĐỒ ĂN,TRÁNG MIỆNG"),
       ("BUFFET BUỔI TRƯA", 90000, "SUẤT", "ĐẦY ĐỦ ĐỒ ĂN,TRÁNG MIỆNG"),
       ("BUFFET BUỔI TỐI", 16000, "SUẤT", "ĐẦY ĐỦ ĐỒ ĂN,TRÁNG MIỆNG");

insert into contract(start_date, end_date, deposit, employee_id, costomer_id, facility_id)
values ('2020-12-08', '2020-12-08', '0', 3, 1, 3),
       ('2020-07-14', '2020-07-21', '200000', 7, 3, 1),
       ('2021-03-15', '2021-03-17', '50000', 3, 4, 2),
       ('2021-01-14', '2021-01-18', '100000', 7, 5, 5),
       ('2021-07-14', '2021-07-15', '0', 7, 2, 6),
       ('2021-06-01', '2021-06-03', '0', 7, 7, 6),
       ('2021-09-02', '2021-09-05', '100000', 7, 4, 4),
       ('2021-06-17', '2021-06-18', '150000', 3, 4, 1),
       ('2020-11-19', '2020-11-19', '0', 3, 4, 3),
       ('2021-04-12', '2021-04-14', '0', 10, 3, 5),
       ('2021-04-25', '2021-04-25', '0', 2, 2, 1),
       ('2021-05-25', '2021-05-27', '0', 7, 10, 1);

insert into contract_detail(quantity, contract_id, attach_facility_id)
values (5, 2, 4),
       (8, 2, 5),
       (15, 2, 6),
       (1, 3, 1),
       (11, 3, 2),
       (1, 1, 3),
       (2, 1, 2),
       (2, 12, 2);