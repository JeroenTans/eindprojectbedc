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

-- Standard Amsterdam tips
INSERT INTO tip_amsterdams (address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES ('Westermarkt 20', 'Anne Frank huis, wie kent dit niet? In het prachtige Jordaan doe je een stap terug in de tijd. Helaas in dit huis een iets donkerdere tijd..', 'No Group', false, false, false, true, false, false, 'nova@admin', 'annefrank.png');

INSERT INTO tip_amsterdams (address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES ('Westermarkt 20', 'Vlak bij het centraal station heb je een prachtig uitzicht over een aantal grachten panden. In de vroegere uurtjes kan dit pittoreske uitzichten opleveren', 'No Group', false, false, false, true, false, false, 'nova@admin', 'viewcanalhouse.png');

INSERT INTO tip_amsterdams (address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES ('Singel 101', 'Prachtig bankje op de torensluis brug', 'No Group', false, false, false, true, false, false, 'nova@admin', 'benchamsterdam.png');

INSERT INTO tip_amsterdams (address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES ('Elandsgracht 150', 'Sloepdelen Amsterdam, hier kan je een bootje huren en lekker rond varen door de grachten', 'No Group', false, false, false, true, false, false, 'nova@admin', 'boat.png');

-- Prive tips
INSERT INTO tip_amsterdams (address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES ('Museumplein', 'Ik heb hier heerlijk geschaatst! erg bijzonder, midden op één van de drukste pleinen in Amsterdam op het ijs! Vergeet geen handschoenen aan te doen. Vrijdag avond word er muziek gedraait en kan je warme chocolademelk bestellen, Veel plezier!', 'No Group', false, true, false, false, false, true , 'nova@user', 'iceskating.png');

INSERT INTO tip_amsterdams (address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES ('De Dam', 'Op de dam is komende zaterdag (elke derde zaterdag van januari) een markt waar je gratis je eigen bosje tulpen kan samenstellen! Dit is om de opening van het tulpen seizoen te vieren. De geel met rode tulpen zijn prachtig dit jaar!', 'No Group', false, true, false, false, false, true , 'malou@user', 'tullips.png');

-- Public tips
INSERT INTO tip_amsterdams (address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES ('Vondelpark', 'Komende donderdag is hier een optreden van een aantal Reggea artiesten, wees er optijd bij zodat je een goed plekje hebt.', 'No Group', false, false, true , false, false, true , 'nova@user', 'concertvondelpark.png');

INSERT INTO tip_amsterdams (address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES ('Scheepsvaartmuseum', 'Komende donderdag word het heerlijk weer, als je even wilt afkoelen maar niet naar het zwembar wilt: Bij het scheepsvaartmuseum kan je heerlijk zwemmen en picknicken. Er is een mooie stijger of als je lekker in het gras wilt zitten kan dat natuurlijk ook!', 'No Group', false, false , true , false, false, true , 'malou@user', 'swim.png');

-- Group tips (only group with groupname Tipsy)
INSERT INTO tip_amsterdams (address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES ('NDSM-werf', 'Hee groep members! het word lekker weer morgen, zullen we naar plek op het ndsm-werf gaan?', 'Tipsy', true , false , false , false, false, false, 'nova@user', 'plekndsm.png');

INSERT INTO tip_amsterdams (address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES ('Amsterdam Noord', 'Hi dames en heren, ik heb echt een leuk tentje ontdekt in Amsterdam Noord. Het heet de cleuvel. Je kan er lekker in de zon zitten, zwemmen en drankjes drinken. Ze hebben ook leuke bord spellen!', 'Tipsy', true , false , false , false, false, false, 'malou@user', 'cleuvelnoord.png');

-- received tips
INSERT INTO tip_amsterdams (address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES ('Vondelpark', 'Komende donderdag is hier een optreden van een aantal Reggea artiesten, wees er optijd bij zodat je een goed plekje hebt.', 'No Group', false, false, true , false, true , false , 'malou@user', 'concertvondelpark.png');

INSERT INTO tip_amsterdams (address, explanation, group_name, is_group_tip, is_private_tip, is_public_tip, is_standard_tip, received_tip, send_tip, username, picture_path) VALUES ('Scheepsvaartmuseum', 'Komende donderdag word het heerlijk weer, als je even wilt afkoelen maar niet naar het zwembar wilt: Bij het scheepsvaartmuseum kan je heerlijk zwemmen en picknicken. Er is een mooie stijger of als je lekker in het gras wilt zitten kan dat natuurlijk ook!', 'No Group', false, false , true , false, true , false , 'nova@user', 'swim.png');
