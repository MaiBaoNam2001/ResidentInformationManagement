DO
$$
    BEGIN
        INSERT INTO project (id, name, area)
        VALUES ('6d1c2ca7', 'The Beverly Bolari', 'Long Bình, Quận 9'),
               ('5123c665', 'The Grand Sentosa', 'Phước Kiển, Nhà Bè'),
               ('e7c28635', 'The Privia', 'An Lạc, Bình Tân'),
               ('796ac59b', 'The Classia', 'Phú Hữu, Quận 9'),
               ('f7ffb071', 'The Lumiere Boulevard', 'Long Thanh Mỹ, Quận 9')
        ON CONFLICT DO NOTHING;

        INSERT INTO building (id, name, project_id)
        VALUES ('d10819dd', 'Skiba', '6d1c2ca7'),
               ('da6f6593', 'Demizz', '6d1c2ca7'),
               ('416396d4', 'Fivechat', '6d1c2ca7'),

               ('5efe0986', 'Myworks', '5123c665'),
               ('a01de246', 'Dynazzy', '5123c665'),
               ('714b9776', 'Jabbercube', '5123c665'),

               ('c030fe99', 'Thoughtsphere', 'e7c28635'),
               ('005743e3', 'Jaxworks', 'e7c28635'),
               ('4cd4fe68', 'Fadeo', 'e7c28635'),

               ('bd609db6', 'Meemm', '796ac59b'),
               ('bca4a091', 'Tazzy', '796ac59b'),
               ('7d899a7c', 'Devify', '796ac59b'),

               ('994d4048', 'Gigaclub', 'f7ffb071'),
               ('6e17ba0d', 'Realcube', 'f7ffb071'),
               ('181fd50b', 'Gabtune', 'f7ffb071')
        ON CONFLICT DO NOTHING;

        INSERT INTO floor(id, number, building_id)
        VALUES ('54e50255', 1, 'd10819dd'),
               ('5f44b16e', 2, 'd10819dd'),
               ('7cf9cd22', 3, 'd10819dd'),

               ('1c0fc42f', 1, 'da6f6593'),
               ('4ce89573', 2, 'da6f6593'),
               ('ffab8385', 3, 'da6f6593'),

               ('62de22e3', 1, '416396d4'),
               ('2a41eb6c', 2, '416396d4'),
               ('51ed8eda', 3, '416396d4'),

               ('d6a509b0', 1, '5efe0986'),
               ('aadc2f2c', 2, '5efe0986'),
               ('49c0fe64', 3, '5efe0986'),

               ('643c0ee7', 1, 'a01de246'),
               ('485eadd0', 2, 'a01de246'),
               ('39b8626d', 3, 'a01de246'),

               ('1a0db73a', 1, '714b9776'),
               ('8f5ae863', 2, '714b9776'),
               ('27346d47', 3, '714b9776'),

               ('9a5e10ec', 1, 'c030fe99'),
               ('5390f55c', 2, 'c030fe99'),
               ('641939bc', 3, 'c030fe99'),

               ('dd502daa', 1, '005743e3'),
               ('6064228c', 2, '005743e3'),
               ('40ffe870', 3, '005743e3'),

               ('cd73af6d', 1, '4cd4fe68'),
               ('65eb770e', 2, '4cd4fe68'),
               ('a7158ad9', 3, '4cd4fe68'),

               ('8bad4cfa', 1, 'bd609db6'),
               ('00f86749', 2, 'bd609db6'),
               ('83f30c75', 3, 'bd609db6'),

               ('1e010fb4', 1, 'bca4a091'),
               ('d8fde56f', 2, 'bca4a091'),
               ('f4ce8fa8', 3, 'bca4a091'),

               ('8899d651', 1, '7d899a7c'),
               ('0e9095e5', 2, '7d899a7c'),
               ('1dd290d4', 3, '7d899a7c'),

               ('01b4345f', 1, '994d4048'),
               ('c6799145', 2, '994d4048'),
               ('13b4c132', 3, '994d4048'),

               ('8afc8645', 1, '6e17ba0d'),
               ('a6d3d2e5', 2, '6e17ba0d'),
               ('1ddcd0cb', 3, '6e17ba0d'),

               ('cb5f3b75', 1, '181fd50b'),
               ('53fbd413', 2, '181fd50b'),
               ('a4f7687d', 3, '181fd50b')
        ON CONFLICT DO NOTHING;

        INSERT INTO apartment(id, name, floor_id)
        VALUES ('1118eae6', 'Phòng số 101', '54e50255'),
               ('10c98f0e', 'Phòng số 102', '54e50255'),
               ('1e49dae6', 'Phòng số 103', '54e50255'),

               ('1254247f', 'Phòng số 201', '5f44b16e'),
               ('2898f0b4', 'Phòng số 202', '5f44b16e'),
               ('19c572b9', 'Phòng số 203', '5f44b16e'),

               ('aa919090', 'Phòng số 301', '7cf9cd22'),
               ('bd8ce65c', 'Phòng số 302', '7cf9cd22'),
               ('cea3f932', 'Phòng số 303', '7cf9cd22'),


               ('96088f13', 'Phòng số 101', '1c0fc42f'),
               ('4e98496a', 'Phòng số 102', '1c0fc42f'),
               ('70483dd2', 'Phòng số 103', '1c0fc42f'),

               ('e0ef8d9b', 'Phòng số 201', '4ce89573'),
               ('3284d111', 'Phòng số 202', '4ce89573'),
               ('bc6c6ab4', 'Phòng số 203', '4ce89573'),

               ('3b8094e8', 'Phòng số 301', 'ffab8385'),
               ('5b92accc', 'Phòng số 302', 'ffab8385'),
               ('84e63a5f', 'Phòng số 303', 'ffab8385'),


               ('46d16f84', 'Phòng số 101', '62de22e3'),
               ('034c4302', 'Phòng số 102', '62de22e3'),
               ('d3d62792', 'Phòng số 103', '62de22e3'),

               ('258079fa', 'Phòng số 201', '2a41eb6c'),
               ('2e79e1f5', 'Phòng số 202', '2a41eb6c'),
               ('2c904b04', 'Phòng số 203', '2a41eb6c'),

               ('7be6e1f3', 'Phòng số 301', '51ed8eda'),
               ('8dbce786', 'Phòng số 302', '51ed8eda'),
               ('b76a0c68', 'Phòng số 303', '51ed8eda'),


               ('0c775c87', 'Phòng số 101', 'd6a509b0'),
               ('c15740cc', 'Phòng số 102', 'd6a509b0'),
               ('c6336780', 'Phòng số 103', 'd6a509b0'),

               ('1ceac498', 'Phòng số 201', 'aadc2f2c'),
               ('4730b812', 'Phòng số 202', 'aadc2f2c'),
               ('a71306ba', 'Phòng số 203', 'aadc2f2c'),

               ('750a31a4', 'Phòng số 301', '49c0fe64'),
               ('bb97382a', 'Phòng số 302', '49c0fe64'),
               ('5b5a1df5', 'Phòng số 303', '49c0fe64'),


               ('5c0b6c9d', 'Phòng số 101', '643c0ee7'),
               ('d788ed36', 'Phòng số 102', '643c0ee7'),
               ('62b64586', 'Phòng số 103', '643c0ee7'),

               ('f21d0b54', 'Phòng số 201', '485eadd0'),
               ('43f56ca1', 'Phòng số 202', '485eadd0'),
               ('d4378e21', 'Phòng số 203', '485eadd0'),

               ('1c549394', 'Phòng số 301', '39b8626d'),
               ('fff7cbfc', 'Phòng số 302', '39b8626d'),
               ('576dd3aa', 'Phòng số 303', '39b8626d'),


               ('8ee042c6', 'Phòng số 101', '1a0db73a'),
               ('5430a9b0', 'Phòng số 102', '1a0db73a'),
               ('9ea10546', 'Phòng số 103', '1a0db73a'),

               ('3da83e8d', 'Phòng số 201', '8f5ae863'),
               ('fe972c8d', 'Phòng số 202', '8f5ae863'),
               ('452764c7', 'Phòng số 203', '8f5ae863'),

               ('5fe77032', 'Phòng số 301', '27346d47'),
               ('92b3a6af', 'Phòng số 302', '27346d47'),
               ('efccbbe8', 'Phòng số 303', '27346d47'),


               ('6c2cbd12', 'Phòng số 101', '9a5e10ec'),
               ('228d0daf', 'Phòng số 102', '9a5e10ec'),
               ('925b033d', 'Phòng số 103', '9a5e10ec'),

               ('458a57fc', 'Phòng số 201', '5390f55c'),
               ('adb1caaf', 'Phòng số 202', '5390f55c'),
               ('e71caac0', 'Phòng số 203', '5390f55c'),

               ('2deb6ee7', 'Phòng số 301', '641939bc'),
               ('932acddc', 'Phòng số 302', '641939bc'),
               ('3ddaba45', 'Phòng số 303', '641939bc'),


               ('31782425', 'Phòng số 101', 'dd502daa'),
               ('f36b3470', 'Phòng số 102', 'dd502daa'),
               ('0bd2363f', 'Phòng số 103', 'dd502daa'),

               ('998f16ac', 'Phòng số 201', '6064228c'),
               ('0487177b', 'Phòng số 202', '6064228c'),
               ('ccab63cb', 'Phòng số 203', '6064228c'),

               ('9dbc9749', 'Phòng số 301', '40ffe870'),
               ('e23a975c', 'Phòng số 302', '40ffe870'),
               ('0543c703', 'Phòng số 303', '40ffe870'),


               ('ab114386', 'Phòng số 101', 'cd73af6d'),
               ('ae2a97b9', 'Phòng số 102', 'cd73af6d'),
               ('39b720d1', 'Phòng số 103', 'cd73af6d'),

               ('a053bf41', 'Phòng số 201', '65eb770e'),
               ('13291217', 'Phòng số 202', '65eb770e'),
               ('e8d2b6fd', 'Phòng số 203', '65eb770e'),

               ('16c7af81', 'Phòng số 301', 'a7158ad9'),
               ('97fd9f34', 'Phòng số 302', 'a7158ad9'),
               ('9ff2dfe2', 'Phòng số 303', 'a7158ad9'),


               ('22ab6afc', 'Phòng số 101', '8bad4cfa'),
               ('bf441a2f', 'Phòng số 102', '8bad4cfa'),
               ('4c1076ee', 'Phòng số 103', '8bad4cfa'),

               ('51642ecd', 'Phòng số 201', '00f86749'),
               ('e20a95f3', 'Phòng số 202', '00f86749'),
               ('46308fa8', 'Phòng số 203', '00f86749'),

               ('666cc917', 'Phòng số 301', '83f30c75'),
               ('67ef7155', 'Phòng số 302', '83f30c75'),
               ('d759aaa9', 'Phòng số 303', '83f30c75'),


               ('8ce10d50', 'Phòng số 101', '1e010fb4'),
               ('05bc16fe', 'Phòng số 102', '1e010fb4'),
               ('c5cffb47', 'Phòng số 103', '1e010fb4'),

               ('c2fe9336', 'Phòng số 201', 'd8fde56f'),
               ('005e7933', 'Phòng số 202', 'd8fde56f'),
               ('cbba0409', 'Phòng số 203', 'd8fde56f'),

               ('4de4eb09', 'Phòng số 301', 'f4ce8fa8'),
               ('0bdc3df2', 'Phòng số 302', 'f4ce8fa8'),
               ('5396b4e9', 'Phòng số 303', 'f4ce8fa8'),


               ('d21d6e55', 'Phòng số 101', '8899d651'),
               ('1e94620f', 'Phòng số 102', '8899d651'),
               ('38c510db', 'Phòng số 103', '8899d651'),

               ('b9e3a3c5', 'Phòng số 201', '0e9095e5'),
               ('71424211', 'Phòng số 202', '0e9095e5'),
               ('5c4b0458', 'Phòng số 203', '0e9095e5'),

               ('63ddd443', 'Phòng số 301', '1dd290d4'),
               ('cace1c4f', 'Phòng số 302', '1dd290d4'),
               ('9a5f9af7', 'Phòng số 303', '1dd290d4'),


               ('8656f38f', 'Phòng số 101', '01b4345f'),
               ('5449dd35', 'Phòng số 102', '01b4345f'),
               ('38bc0b68', 'Phòng số 103', '01b4345f'),

               ('22854b82', 'Phòng số 201', 'c6799145'),
               ('09ac7c24', 'Phòng số 202', 'c6799145'),
               ('32f881f3', 'Phòng số 203', 'c6799145'),

               ('dfb490f5', 'Phòng số 301', '13b4c132'),
               ('3180cdd9', 'Phòng số 302', '13b4c132'),
               ('5b826064', 'Phòng số 303', '13b4c132'),


               ('a629d4d6', 'Phòng số 101', '8afc8645'),
               ('ee0788e8', 'Phòng số 102', '8afc8645'),
               ('68eb0d79', 'Phòng số 103', '8afc8645'),

               ('f1752acd', 'Phòng số 201', 'a6d3d2e5'),
               ('29ba5d8f', 'Phòng số 202', 'a6d3d2e5'),
               ('403c91f6', 'Phòng số 203', 'a6d3d2e5'),

               ('8e8a7f13', 'Phòng số 301', '1ddcd0cb'),
               ('1e81dc94', 'Phòng số 302', '1ddcd0cb'),
               ('3d5865bb', 'Phòng số 303', '1ddcd0cb'),


               ('0d4926ab', 'Phòng số 101', 'cb5f3b75'),
               ('dce38a26', 'Phòng số 102', 'cb5f3b75'),
               ('619ef7bc', 'Phòng số 103', 'cb5f3b75'),

               ('b311a323', 'Phòng số 201', '53fbd413'),
               ('0ed6a5b6', 'Phòng số 202', '53fbd413'),
               ('8dd9c7f1', 'Phòng số 203', '53fbd413'),

               ('4f776e29', 'Phòng số 301', 'a4f7687d'),
               ('38d92131', 'Phòng số 302', 'a4f7687d'),
               ('cdbf490a', 'Phòng số 303', 'a4f7687d')
        ON CONFLICT DO NOTHING;

        INSERT INTO customer (id, name, date_of_birth, gender, phone, email, address, type,
                              identity_card, is_deleted)
        VALUES ('e858ecff', 'Nguyễn Thị Hồng Ngọc', '1997-07-22', 'Nữ', '0394857697', 'hongngoc.nguyenthi@gmail.com',
                'Đồng Tháp', 'Cư dân', '318713762', false),
               ('3bb5def1', 'Lê Thị Bảo Châu', '1997-10-10', 'Nữ', '0365464566', 'baochau.lethi@gmail.com', 'Đồng Tháp',
                'Cư dân', '495873491', false),
               ('4d44389f', 'Bùi Thị Yến Nhi', '1997-04-20', 'Nữ', '0354657787',
                'yennhi.buithi@gmail.com', 'An Giang',
                'Cư dân', '472398479', false),
               ('47cae4e7', 'Trần Thị Như Quỳnh', '1998-05-18', 'Nữ', '0391157697', 'nhuquynh.tranthi@gmail.com',
                'An Giang', 'Cư dân', '432947239', false),
               ('473c2151', 'Nguyễn Đăng Khoa', '1994-10-10', 'Nam', '0444857697', 'dangkhoa.nguyen@gmail.com',
                'Đồng Nai', 'Cư dân', '472384853', false),
               ('efe6a422', 'Trần Thị Anh Thư', '1998-04-10', 'Nữ', '0287532155', 'anhthu.tranthi@gmail.com',
                'Đồng Nai', 'Cư dân', '137923719', false),
               ('87239f39', 'Nguyễn Bảo Duy', '2009-08-09', 'Nam', '0289632542', 'baoduy.nguyen@gmail.com', 'Đồng Nai',
                'Cư dân', '573495743', false),
               ('a72c065d', 'Hồ Tuấn Hưng', '1999-05-20', 'Nam', '0444854697', 'tuanhung.ho@gmail.com', 'Nha Trang',
                'Khách vãng lai', '435734563', false),
               ('81400093', 'Hồ Thị Cẩm Tiên', '1996-10-04', 'Nữ', '0394457697', 'camtien.hothi@gmail.com', 'Lâm Đồng',
                'Khách vãng lai', '458345656', false),
               ('6d1c2ca7', 'Trần Thành Danh', '1995-10-10', 'Nam', '0394857497', 'thanhdanh.tran@gmail.com', 'Đà Lạt',
                'Khách vãng lai', '567348756', false)
        ON CONFLICT DO NOTHING;

        INSERT INTO parking_area(id, name, building_id)
        VALUES ('7cd3214e', 'Bãi đỗ xe Skiba', 'd10819dd'),
               ('9603463c', 'Bãi đỗ xe Demizz', 'da6f6593'),
               ('17e9335b', 'Bãi đỗ xe Fivechat', '416396d4'),

               ('8659d747', 'Bãi đỗ xe Myworks', '5efe0986'),
               ('3bdd54ef', 'Bãi đỗ xe Dynazzy', 'a01de246'),
               ('b6c67b53', 'Bãi đỗ xe Jabbercube', '714b9776'),

               ('1f1e46d5', 'Bãi đỗ xe Thoughtsphere', 'c030fe99'),
               ('c7f03024', 'Bãi đỗ xe Jaxworks', '005743e3'),
               ('8ecf3157', 'Bãi đỗ xe Fadeo', '4cd4fe68'),

               ('f0261cd0', 'Bãi đỗ xe Meemm', 'bd609db6'),
               ('5647d144', 'Bãi đỗ xe Tazzy', 'bca4a091'),
               ('a14cca0b', 'Bãi đỗ xe Devify', '7d899a7c'),

               ('8aa6ee62', 'Bãi đỗ xe Gigaclub', '994d4048'),
               ('58ba150a', 'Bãi đỗ xe Realcube', '6e17ba0d'),
               ('7d48b369', 'Bãi đỗ xe Gabtune', '181fd50b')
        ON CONFLICT DO NOTHING;

        INSERT INTO parking_type(id, name, price, unit)
        VALUES (1, 'Theo giờ', 10000, 'Giờ'),
               (2, 'Theo tháng', 300000, 'Tháng'),
               (3, 'Theo ngày', 50000, 'Ngày')
        ON CONFLICT DO NOTHING;

        INSERT INTO apartment_register(id, customer_id, apartment_id, is_host, resident_card, motorbike_card, car_card,
                                       register_date)
        VALUES ('ab0aa40e', 'e858ecff', '1118eae6', true,
                '{
                  "active": true,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "building": {
                        "id": "d10819dd",
                        "controls": []
                      },
                      "floor": {
                        "id": "54e50255",
                        "controls": []
                      },
                      "apartment": {
                        "id": "1118eae6",
                        "controls": []
                      }
                    }
                  }
                }',
                '{
                  "active": true,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "parking_area": {
                        "id": "7cd3214e",
                        "controls": []
                      }
                    }
                  }
                }',
                '{
                  "active": false,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "parking_area": {
                        "id": "7cd3214e",
                        "controls": []
                      }
                    }
                  }
                }', '2022-10-21'),
               ('cf500c8c', '3bb5def1', '1118eae6', false,
                '{
                  "active": true,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "building": {
                        "id": "d10819dd",
                        "controls": []
                      },
                      "floor": {
                        "id": "54e50255",
                        "controls": []
                      },
                      "apartment": {
                        "id": "1118eae6",
                        "controls": []
                      }
                    }
                  }
                }',
                '{
                  "active": true,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "parking_area": {
                        "id": "7cd3214e",
                        "controls": []
                      }
                    }
                  }
                }',
                '{
                  "active": false,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "parking_area": {
                        "id": "7cd3214e",
                        "controls": []
                      }
                    }
                  }
                }', '2022-10-21'),
               ('70f45a65', '4d44389f', '1118eae6', false,
                '{
                  "active": true,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "building": {
                        "id": "d10819dd",
                        "controls": []
                      },
                      "floor": {
                        "id": "54e50255",
                        "controls": []
                      },
                      "apartment": {
                        "id": "1118eae6",
                        "controls": []
                      }
                    }
                  }
                }',
                '{
                  "active": true,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "parking_area": {
                        "id": "7cd3214e",
                        "controls": []
                      }
                    }
                  }
                }',
                '{
                  "active": false,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "parking_area": {
                        "id": "7cd3214e",
                        "controls": []
                      }
                    }
                  }
                }', '2022-10-21'),
               ('1e520a7b', '47cae4e7', '1118eae6', false,
                '{
                  "active": true,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "building": {
                        "id": "d10819dd",
                        "controls": []
                      },
                      "floor": {
                        "id": "54e50255",
                        "controls": []
                      },
                      "apartment": {
                        "id": "1118eae6",
                        "controls": []
                      }
                    }
                  }
                }',
                '{
                  "active": true,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "parking_area": {
                        "id": "7cd3214e",
                        "controls": []
                      }
                    }
                  }
                }',
                '{
                  "active": false,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "parking_area": {
                        "id": "7cd3214e",
                        "controls": []
                      }
                    }
                  }
                }', '2022-10-21'),
               ('34dc9805', '473c2151', '96088f13', true,
                '{
                  "active": true,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "building": {
                        "id": "da6f6593",
                        "controls": []
                      },
                      "floor": {
                        "id": "1c0fc42f",
                        "controls": []
                      },
                      "apartment": {
                        "id": "96088f13",
                        "controls": []
                      }
                    }
                  }
                }',
                '{
                  "active": true,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "parking_area": {
                        "id": "9603463c",
                        "controls": []
                      }
                    }
                  }
                }',
                '{
                  "active": false,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "parking_area": {
                        "id": "9603463c",
                        "controls": []
                      }
                    }
                  }
                }', '2022-10-21'),
               ('26f9efa0', 'efe6a422', '96088f13', false,
                '{
                  "active": true,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "building": {
                        "id": "da6f6593",
                        "controls": []
                      },
                      "floor": {
                        "id": "1c0fc42f",
                        "controls": []
                      },
                      "apartment": {
                        "id": "96088f13",
                        "controls": []
                      }
                    }
                  }
                }',
                '{
                  "active": true,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "parking_area": {
                        "id": "9603463c",
                        "controls": []
                      }
                    }
                  }
                }',
                '{
                  "active": false,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "parking_area": {
                        "id": "9603463c",
                        "controls": []
                      }
                    }
                  }
                }', '2022-10-21'),
               ('f0feb3bc', '87239f39', '96088f13', false,
                '{
                  "active": true,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "building": {
                        "id": "da6f6593",
                        "controls": []
                      },
                      "floor": {
                        "id": "1c0fc42f",
                        "controls": []
                      },
                      "apartment": {
                        "id": "96088f13",
                        "controls": []
                      }
                    }
                  }
                }',
                '{
                  "active": false,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "parking_area": {
                        "id": "9603463c",
                        "controls": []
                      }
                    }
                  }
                }',
                '{
                  "active": false,
                  "project": {
                    "id": "6d1c2ca7",
                    "range": {
                      "parking_area": {
                        "id": "9603463c",
                        "controls": []
                      }
                    }
                  }
                }', '2022-10-21')
        ON CONFLICT DO NOTHING;

        INSERT INTO parking_register(id, customer_id, parking_area_id, license_plate, brand_name, color, vehicle_type,
                                     register_date, parking_type_id)
        VALUES ('bb4eace3', 'e858ecff', '7cd3214e', '02927b75', 'Vision', 'Xanh', 'Xe máy', '2022-10-21', 2),
               ('287aa385', '3bb5def1', '7cd3214e', '7d75d12e', 'Vision', 'Trắng', 'Xe máy', '2022-10-21', 2),
               ('6f75369e', '4d44389f', '7cd3214e', '397a2f7d', 'Lead', 'Đỏ', 'Xe máy', '2022-10-21', 2),
               ('826e4480', '47cae4e7', '7cd3214e', '2130e892', 'Vision', 'Xám', 'Xe máy', '2022-10-21', 2),

               ('a6b2ec51', '473c2151', '9603463c', '6519091a', 'Air Blade', 'Đen', 'Xe máy', '2022-10-21', 2),
               ('8e9bc6fa', 'efe6a422', '9603463c', '07c4ffcd', 'Lead', 'Trắng', 'Xe máy', '2022-10-21', 2),

               ('98b35dc8', 'a72c065d', '7cd3214e', 'c1f29d80', 'Wave', 'Đen', 'Xe máy', '2022-10-21', 3),
               ('f4f51476', '81400093', '7cd3214e', 'd205e863', 'Vision', 'Xanh', 'Xe máy', '2022-10-21', 3),
               ('a252f05e', '6d1c2ca7', '7cd3214e', '278f6276', 'Air Blade', 'Đỏ', 'Xe máy', '2022-10-21', 3)
        ON CONFLICT DO NOTHING;

        INSERT INTO role(code, name)
        VALUES ('ROLE_SUPER_ADMIN', 'Super Admin'),
               ('ROLE_ADMIN', 'Admin'),
               ('ROLE_MANAGER', 'Manager'),
               ('ROLE_SECURITY', 'Security'),
               ('ROLE_CUSTOMER', 'Customer')
        ON CONFLICT DO NOTHING;

        INSERT INTO users(username, phone, email, password, role_code)
        VALUES ('dinhhuy.nguyen', '0287563254', 'dinhhuy.nguyen@gmail.com',
                '$2a$10$qv8ssuwrnp/yhpwtpqdgp.mxj01hcw4ji6wkvp6.qkwwx1zxhqxyg', 'ROLE_SUPER_ADMIN')
        ON CONFLICT DO NOTHING;

        INSERT INTO authority(code, name, options)
        VALUES ('ACCOUNT_REGISTER', 'Account Register', '{
          "ENABLE": "ENABLE"
        }')
        ON CONFLICT DO NOTHING;
    END;
$$;