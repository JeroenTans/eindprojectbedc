
DELETE FROM users;
DELETE FROM authorities;
DELETE FROM tip_amsterdams;

-- Nova admin & user
INSERT INTO users (username, password, enabled, authority) VALUES ('nova@admin', '$2y$12$emZ8FwOGZ.LcRjcu/p2BNO9HWZ7XUASUtLl86Xw5gJd2RB3XVCxyO', true, 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('nova@admin', 'ROLE_ADMIN');

INSERT INTO users (username, password, enabled, authority, group_name) VALUES ('nova@user', '$2y$12$emZ8FwOGZ.LcRjcu/p2BNO9HWZ7XUASUtLl86Xw5gJd2RB3XVCxyO', true, 'ROLE_USER', 'Tipsy');
INSERT INTO authorities (username, authority) VALUES ('nova@user', 'ROLE_USER');

-- Malou admin & user
INSERT INTO users (username, password, enabled, authority) VALUES ('malou@admin', '$2y$12$emZ8FwOGZ.LcRjcu/p2BNO9HWZ7XUASUtLl86Xw5gJd2RB3XVCxyO', true, 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('malou@admin', 'ROLE_ADMIN');

INSERT INTO users (username, password, enabled, authority, group_name) VALUES ('malou@user', '$2y$12$emZ8FwOGZ.LcRjcu/p2BNO9HWZ7XUASUtLl86Xw5gJd2RB3XVCxyO', true, 'ROLE_USER', 'Tipsy');
INSERT INTO authorities (username, authority) VALUES ('malou@user', 'ROLE_USER');

-- Rein admin & user
INSERT INTO users (username, password, enabled, authority) VALUES ('rein@admin', '$2y$12$emZ8FwOGZ.LcRjcu/p2BNO9HWZ7XUASUtLl86Xw5gJd2RB3XVCxyO', true, 'ROLE_ADMIN');
INSERT INTO authorities (username, authority) VALUES ('rein@admin', 'ROLE_ADMIN');

INSERT INTO users (username, password, enabled, authority, group_name) VALUES ('rein@user', '$2y$12$emZ8FwOGZ.LcRjcu/p2BNO9HWZ7XUASUtLl86Xw5gJd2RB3XVCxyO', true, 'ROLE_USER', 'Tipsy');
INSERT INTO authorities (username, authority) VALUES ('rein@user', 'ROLE_USER');

-- Standard Amsterdam tips & review
INSERT INTO tip_amsterdams (id, address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES (1001 ,'Westermarkt 20', 'Anne Frank huis, wie kent dit niet? In het prachtige Jordaan doe je een stap terug in de tijd. Helaas ga je in dit huis een iets donkerdere tijd in..', 'No Group', false, false, false, true, false, false, 'nova@admin', 'annefrank.png');

INSERT INTO tip_amsterdams (id, address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES (1002, 'Centraal station', 'Vlak bij het centraal station heb je een prachtig uitzicht over een aantal grachtenpanden. In de vroegere uurtjes kan dit pittoreske uitzichten opleveren', 'No Group', false, false, false, true, false, false, 'nova@admin', 'viewcanalhouse.png');

INSERT INTO tip_amsterdams (id, address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES (1003, 'Singel 101', 'Prachtig bankje op de torensluis brug', 'No Group', false, false, false, true, false, false, 'nova@admin', 'benchamsterdam.png');

INSERT INTO tip_amsterdams (id, address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES (1004, 'Elandsgracht 150', 'Sloepdelen Amsterdam, hier kan je een bootje huren en lekker rond varen door de grachten', 'No Group', false, false, false, true, false, false, 'nova@admin', 'boat.png');

INSERT INTO reviews (tip_amsterdam_id, address, broken_heart, comment, heart) VALUES (1001, 'Westermarkt 20', false, 'Erg bijzonder, helemaal als je haar dagboek hebt gelezen, goed om af en toe stil te staan bij wat er in het verleden is gebeurd.', true);

INSERT INTO reviews (tip_amsterdam_id, address, broken_heart, comment, heart) VALUES (1002, 'Centraal station', true, 'Niets bijzonders aan, wel mooie plek', false );

INSERT INTO reviews (tip_amsterdam_id, address, broken_heart, comment, heart) VALUES (1003, 'Singel 101', false, 'Erg mooie plek voor een bankje zeg!', true );

INSERT INTO reviews (tip_amsterdam_id, address, broken_heart, comment, heart) VALUES (1004, 'Elandsgracht 150', false, 'Bootjes waren mooi en nieuw, had graag ene plattengrond van de grachten gehad maar het was erg leuk!', true);

-- Prive tips & review
INSERT INTO tip_amsterdams (id, address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES (1005, 'Museumplein', 'Ik heb hier heerlijk geschaatst! erg bijzonder, midden op één van de drukste pleintjes in Amsterdam op het ijs! Vergeet geen handschoenen aan te doen. Vrijdag avond word er muziek gedraait en kan je warme chocolademelk bestellen, Veel plezier!', 'No Group', false, true, false, false, false, true , 'nova@user', 'iceskating.jpg');

INSERT INTO tip_amsterdams (id, address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES (1006, 'De Dam', 'Op de dam is komende zaterdag (elke derde zaterdag van januari) een markt waar je gratis je eigen bosje tulpen kan samenstellen! Dit is om de opening van het tulpen seizoen te vieren. De geel met rode tulpen zijn prachtig dit jaar!', 'No Group', false, true, false, false, false, true , 'malou@user', 'dam.jpg');

INSERT INTO tip_amsterdams (id, address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES (1013, 'Shell toren', 'Op de bovenste verdieping van de Shell toren kan je een schommel vinden! hier zie je een prachtig uitzicht over Amsterdam!', 'No Group', false, true, false, false, false, true , 'rein@user', 'swing.jpg');

INSERT INTO reviews (tip_amsterdam_id, address, broken_heart, comment, heart) VALUES (1005, 'Museumplein', false, 'Leuke plek om te schaatsen inderdaad! Bedankt!', true);

INSERT INTO reviews (tip_amsterdam_id, address, broken_heart, comment, heart) VALUES (1006, 'De Dam', false, 'Wauw! ik woon al mijn hele leven in de Jordaan en wist dit niet! Bedankt voor de tip, was ontzettend leuk.', true );

INSERT INTO reviews (tip_amsterdam_id, address, broken_heart, comment, heart) VALUES (1013, 'Shell toren', false, 'Super! Wel een beetje eng hoor!', true );

-- Public tips & review
INSERT INTO tip_amsterdams (id, address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES (1007, 'Vondelpark', 'Komende donderdag is hier een optreden van een aantal Reggea artiesten, wees er optijd bij zodat je een goed plekje hebt.', 'No Group', false, false, true , false, false, true , 'nova@user', 'concertvondelpark.jpg');

INSERT INTO tip_amsterdams (id, address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES (1008, 'Scheepsvaartmuseum', 'Komende donderdag word het heerlijk weer, als je even wilt afkoelen maar niet naar het zwembar wilt: Bij het scheepsvaartmuseum kan je heerlijk zwemmen en picknicken. Er is een mooie stijger of als je lekker in het gras wilt zitten kan dat natuurlijk ook!', 'No Group', false, false , true , false, false, true , 'malou@user', 'swim.jpg');

INSERT INTO reviews (tip_amsterdam_id, address, broken_heart, comment, heart) VALUES (1007, 'Vondelpark', false, 'Was druk maar er hing een gezellige sfeer! De muziek was goed', true);

INSERT INTO reviews (tip_amsterdam_id, address, broken_heart, comment, heart) VALUES (1008, 'Scheepsvaartmuseum', false, 'Wat een plek zeg! Als je naast zo n prachtige boot zwemt waan je jezelf bijna in de 17e eeuw. Bedankt!', true );

-- Group tips (only group with groupname Tipsy) & review
INSERT INTO tip_amsterdams (id, address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES (1009, 'NDSM-werf', 'Hee groep members! het word lekker weer morgen, zullen we naar plek op het ndsm-werf gaan?', 'Tipsy', true , false , false , false, false, false, 'nova@user', 'plekndsm.png');

INSERT INTO tip_amsterdams (id, address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES (1010, 'Amsterdam Noord', 'Hi dames en heren, ik heb echt een leuk tentje ontdekt in Amsterdam Noord. Het heet de cleuvel. Je kan er lekker in de zon zitten, zwemmen en drankjes drinken. Ze hebben ook leuke bord spellen!', 'Tipsy', true , false , false , false, false, false, 'malou@user', 'cleuvelnoord.png');

INSERT INTO reviews (tip_amsterdam_id, address, broken_heart, comment, heart) VALUES (1009, 'NDSM-werf', true , 'Sorry! ik kan helaas morgen niet😔. Veel plezier! groeten Malou.', false);

INSERT INTO reviews (tip_amsterdam_id, address, broken_heart, comment, heart) VALUES (1009, 'NDSM-werf', false , 'Jammer Malou! Ik ben er zeker voor! Laten we om 13:00 afspreken, zie jullie daar!', true );

INSERT INTO reviews (tip_amsterdam_id, address, broken_heart, comment, heart) VALUES (1010, 'Amsterdam Noord', false, 'Wat een leuke plek zeg!', true );

-- received tips & review
INSERT INTO tip_amsterdams (id, address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES (1011, 'Vondelpark', 'Komende donderdag is hier een optreden van een aantal Reggea artiesten, wees er optijd bij zodat je een goed plekje hebt.', 'No Group', false, false, false , false, true , false , 'malou@user', 'vondelparktwo.jpg');

INSERT INTO tip_amsterdams (id, address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES (1012, 'Scheepsvaartmuseum', 'Komende donderdag word het heerlijk weer, als je even wilt afkoelen maar niet naar het zwembar wilt: Bij het scheepsvaartmuseum kan je heerlijk zwemmen en picknicken. Er is een mooie stijger of als je lekker in het gras wilt zitten kan dat natuurlijk ook!', 'No Group', false, false , false , false, true , false , 'nova@user', 'scheepsvaartmuseum.jpg');

INSERT INTO tip_amsterdams (id, address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES (1014, 'Jordaan', 'Iedere zaterdag is er een markt in de Jordaan. Er word hier eten verkocht, kleren, kunst, van alles en nog wat. Daarnaast hebben ze de lekkerste poffertjes in town!', 'No Group', false, false, false , false, true , false , 'rein@user', 'saterdaymarked.jpg');

INSERT INTO tip_amsterdams (id, address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES (1015, 'Westerpark', 'Lekker bbqen in het park!!', 'No Group', false, false , true , false, false , true , 'rein@user', 'westerpark.jpg');

INSERT INTO reviews (tip_amsterdam_id, address, broken_heart, comment, heart) VALUES (1011, 'Vondelpark', false, 'Was druk maar er hing een gezellige sfeer! De muziek was goed', true);

INSERT INTO reviews (tip_amsterdam_id, address, broken_heart, comment, heart) VALUES (1012, 'Scheepsvaartmuseum', false, 'Wat een plek zeg! Als je naast zo n prachtige boot zwemt waan je jezelf bijna in de 17e eeuw. Bedankt!', true );

INSERT INTO reviews (tip_amsterdam_id, address, broken_heart, comment, heart) VALUES (1014, 'Jordaan', false, 'Erg leuke tip en heerlijke poffertjes! bedankt!', true );