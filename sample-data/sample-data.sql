INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (1, null, 0, null, 0, 'global');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (2, 'club', 50.06804,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.90829,
        'Klub STUDIO');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (3, 'club', 50.06799,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.90543,
        'Klub Zaścianek');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (4, 'club', 50.06572,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.91559,
        'Klub Gwarek');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (5, 'club', 50.06931,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.90576,
        'Klub Filutek');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (6, 'dormitory', 50.06947,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.90289,
        'Akropol');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (7, 'dormitory', 50.06891,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.90429,
        'Olimp');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (8, 'dormitory', 50.06925,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.90485,
        'Babilon');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (9, 'dormitory', 50.06749,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.90501,
        'Stokrotka');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (10, 'dormitory', 50.06774,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.90711,
        'Kapitol');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (11, 'dormitory', 50.06868,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.90692,
        'Hajduczek');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (12, 'dormitory', 50.06744,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.90615,
        'Straszny Dwór');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (13, 'dormitory', 50.06912,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.90695,
        'Omega');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (14, 'restaurant', 50.06859,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.90991,
        'Sushi 77');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (15, 'restaurant', 50.06768,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.91186,
        'Sticky Fingers Pizzeria');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (16, 'restaurant', 50.06804,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.91259,
        'Restauracja Kavior');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (17, 'restaurant', 50.06934,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.90488,
        'Stołówka Studencka "Pod Babilonem"');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (18, 'faculty', 50.06594,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.91879,
        'Wydział Inżynierii Mechanicznej i Robotyki');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (19, 'faculty', 50.06581,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.91719,
        'Wydział Energetyki i Paliw D4');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (20, 'faculty', 50.06802,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.91264,
        'Centrum Informatyki D-17');
INSERT INTO public.places (id, category, latitude, logo_url, longitude, name)
VALUES (21, 'faculty', 50.06743,
        'https://www.lodplanner.com/wp-content/uploads/AGH-University-of-Science-and-Technology-Logo.png', 19.91652,
        'Wydział Matematyki Stosowanej B-7)');

INSERT INTO public.events (id, description, end_date, image_url, place_id, place_name, start_date, timestamp, title,
                           website_url)
VALUES (3,
        'event 3 Lorem ipsum dolor sit amet, consectetur adipisicing elit. Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus. Phasellus pharetra nulla ac diam. Quisque semper justo at risus.',
        '2023-12-24 00:00:00.000000',
        'https://www.klubstudio.pl/media/cache/event_slider_800/uploads/photo/_0/th-750x500-studio-640b307fe1c05910495534.jpg.web',
        2, 'Klub STUDIO', '2023-12-23 12:00:00.000000', '2023-06-26 03:11:07.000000', 'Wydziałówka XYZ',
        'https://www.google.com');
INSERT INTO public.events (id, description, end_date, image_url, place_id, place_name, start_date, timestamp, title,
                           website_url)
VALUES (1,
        'event 1 Lorem ipsum dolor sit amet, consectetur adipisicing elit. Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus. Phasellus pharetra nulla ac diam. Quisque semper justo at risus.',
        '2023-06-30 03:00:00.000000',
        'https://www.klubstudio.pl/media/cache/event_slider_800/uploads/photo/_0/th-750x500-studio-640b307fe1c05910495534.jpg.web',
        2, 'Klub STUDIO', '2023-06-29 12:00:00.000000', '2023-06-26 03:11:05.000000', 'Wydziałówka WIET',
        'https://www.google.com');
INSERT INTO public.events (id, description, end_date, image_url, place_id, place_name, start_date, timestamp, title,
                           website_url)
VALUES (2,
        'event 2 Lorem ipsum dolor sit amet, consectetur adipisicing elit. Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus. Phasellus pharetra nulla ac diam. Quisque semper justo at risus.',
        '2023-07-26 03:13:18.000000',
        'https://www.klubstudio.pl/media/cache/event_slider_800/uploads/photo/_0/th-750x500-studio-640b307fe1c05910495534.jpg.web',
        2, 'Klub STUDIO', '2023-06-26 03:13:28.000000', '2023-06-26 03:11:07.000000', 'Wydziałówka WIMIR',
        'https://www.google.com');
INSERT INTO public.events (id, description, end_date, image_url, place_id, place_name, start_date, timestamp, title,
                           website_url)
VALUES (4,
        'event Lorem ipsum dolor sit amet, consectetur adipisicing elit. Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus. Phasellus pharetra nulla ac diam. Quisque semper justo at risus.',
        '2024-06-26 00:00:00.000000',
        'https://www.klubstudio.pl/media/cache/event_slider_800/uploads/photo/_0/th-750x500-studio-640b307fe1c05910495534.jpg.web',
        3, 'Klub Zaścianek', '2023-05-30 00:00:00.000000', '2023-06-26 03:11:14.000000', 'Wydziałówka XYZ',
        'https://www.google.com');
INSERT INTO public.events (id, description, end_date, image_url, place_id, place_name, start_date, timestamp, title,
                           website_url)
VALUES (5, 'global event1', '2024-06-26 00:00:00.000000',
        'https://www.klubstudio.pl/media/cache/event_slider_800/uploads/photo/_0/th-750x500-studio-640b307fe1c05910495534.jpg.web',
        1, 'global event', '2023-10-21 22:50:24.000000', '2023-10-21 22:50:28.000000', 'AWS course',
        'https://cri.agh.edu.pl/');
INSERT INTO public.events (id, description, end_date, image_url, place_id, place_name, start_date, timestamp, title,
                           website_url)
VALUES (6,
        'global event 2 Lorem ipsum dolor sit amet, consectetur adipisicing elit. Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus. Phasellus pharetra nulla ac diam. Quisque semper justo at risus. Donec venenatis, turpis vel hendrerit interdum, dui ligula ultricies purus, sed posuere libero dui id orci.',
        '2024-06-26 00:00:00.000000',
        'https://www.klubstudio.pl/media/cache/event_slider_800/uploads/photo/_0/th-750x500-studio-640b307fe1c05910495534.jpg.web',
        1, 'global event', '2023-06-26 03:13:28.000000', '2023-10-21 22:52:20.000000', 'juwenalia',
        'https://cri.agh.edu.pl/');
INSERT INTO public.events (id, description, end_date, image_url, place_id, place_name, start_date, timestamp, title,
                           website_url)
VALUES (7, 'event test 5', '2024-10-22 11:17:54.000000',
        'https://www.klubstudio.pl/media/cache/event_slider_800/uploads/photo/_0/th-750x500-studio-640b307fe1c05910495534.jpg.web',
        14, 'Sushi 77', '2023-10-22 11:18:12.000000', '2023-10-22 11:18:17.000000', 'Dzień RYBY',
        'https://www.orybach.pl/');

INSERT INTO public.offers (id, description, end_date, image_url, place_id, place_name, start_date, timestamp,
                           website_url)
VALUES (1, 'all -10%', '2023-07-26 03:04:34.000000',
        'https://restaumatic-production.imgix.net/uploads/accounts/34896/media_library/58026fe4-3591-4d08-9788-e3bc8bae94d2.jpg',
        13, 'Sushi 77', '2023-06-26 03:04:31.000000', '2023-06-26 03:04:24.000000', null);
INSERT INTO public.offers (id, description, end_date, image_url, place_id, place_name, start_date, timestamp,
                           website_url)
VALUES (2, 'all -20%', '2023-10-29 12:00:00.000000',
        'https://restaumatic-production.imgix.net/uploads/accounts/34896/media_library/58026fe4-3591-4d08-9788-e3bc8bae94d2.jpg',
        13, 'Sushi 77', '2023-08-28 00:00:00.000000', '2023-06-26 03:04:26.000000', null);
INSERT INTO public.offers (id, description, end_date, image_url, place_id, place_name, start_date, timestamp,
                           website_url)
VALUES (3, 'all -12%', '2026-12-24 00:00:00.000000',
        'https://restaumatic-production.imgix.net/uploads/accounts/34896/media_library/58026fe4-3591-4d08-9788-e3bc8bae94d2.jpg',
        14, 'Sticky Fingers Pizzeria', '2022-06-23 00:00:00.000000', '2023-06-26 03:04:27.000000', null);
INSERT INTO public.offers (id, description, end_date, image_url, place_id, place_name, start_date, timestamp,
                           website_url)
VALUES (4, 'all -22%', '2022-06-30 12:00:00.000000',
        'https://restaumatic-production.imgix.net/uploads/accounts/34896/media_library/58026fe4-3591-4d08-9788-e3bc8bae94d2.jpg',
        15, 'Restauracja Kavior', '2023-06-26 15:00:00.000000', '2023-06-26 03:04:28.000000', null);

INSERT INTO public.places_details (id, address, description, last_modified_date, phone_number, timestamp, website_url,
                                   opening_hours)
VALUES (6, 'Juliana Tokarskiego 1, 30-065 Kraków', 'text5', '2023-10-21 22:27:50.000000', '126173703',
        '2023-10-21 22:27:50.000000', 'http://www.miasteczko.agh.edu.pl/', '8:00-17:00');
INSERT INTO public.places_details (id, address, description, last_modified_date, phone_number, timestamp, website_url,
                                   opening_hours)
VALUES (5, 'Józefa Rostafińskiego 10, 30-072 Kraków', 'text4', '2023-10-21 22:27:50.000000', '126174646',
        '2023-10-21 22:27:50.000000', 'http://www.klubfilutek.pl/', '8:00-17:00');
INSERT INTO public.places_details (id, address, description, last_modified_date, phone_number, timestamp, website_url,
                                   opening_hours)
VALUES (2, 'Witolda Budryka 4, 30-072 Kraków', 'text1', '2023-10-21 22:27:50.000000', '126174545',
        '2023-10-21 22:27:50.000000', 'http://www.klubstudio.pl/', '8:00-17:00');
INSERT INTO public.places_details (id, address, description, last_modified_date, phone_number, timestamp, website_url,
                                   opening_hours)
VALUES (18, 'Kawiory 21, 30-055 Kraków', 'D17 test test', '2023-10-21 22:27:50.000000', '123283400',
        '2023-10-21 22:27:50.000000', 'http://www.ki.agh.edu.pl/', '8:00-17:00');
INSERT INTO public.places_details (id, address, description, last_modified_date, phone_number, timestamp, website_url,
                                   opening_hours)
VALUES (14, 'Kawiory 41, 30-055 Kraków', 'bardzo samczne sushi', '2023-10-21 22:27:50.000000', '572057777',
        '2023-10-21 22:27:50.000000', 'https://www.77sushi.com/', '8:00-17:00');
INSERT INTO public.places_details (id, address, description, last_modified_date, phone_number, timestamp, website_url,
                                   opening_hours)
VALUES (4, 'Władysława Reymonta 17, 30-072 Kraków', 'text3', '2023-10-21 22:27:50.000000', '123',
        '2023-10-21 22:27:50.000000', 'http://www.klubgwarek.pl/', '8:00-17:00');
INSERT INTO public.places_details (id, address, description, last_modified_date, phone_number, timestamp, website_url,
                                   opening_hours)
VALUES (3, 'Józefa Rostafińskiego 4, 30-072 Kraków', 'text2', '2023-10-21 22:27:50.000000', '123',
        '2023-10-21 22:27:50.000000', 'http://www.klubzascianek.pl/', '8:00-17:00');

INSERT INTO public.place_details_photos (place_details_id, photos)
VALUES (2, 'https://www.klubstudio.pl/images/about-plyta.jpg');
INSERT INTO public.place_details_photos (place_details_id, photos)
VALUES (2, 'https://www.czestobud.com/wp-content/uploads/2022/05/Rectangle-65.jpg');
INSERT INTO public.place_details_photos (place_details_id, photos)
VALUES (18, 'https://upload.wikimedia.org/wikipedia/commons/9/95/Krakow_AGH_D-17.jpg');
INSERT INTO public.place_details_photos (place_details_id, photos)
VALUES (18, 'https://upload.wikimedia.org/wikipedia/commons/9/95/Krakow_AGH_D-17.jpg');