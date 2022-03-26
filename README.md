# PackTrack
Desktop warehouse-pack-tracking app with embedded h2 database   
This App is a simple solution for buisnesses selling stock in own multiple packs and they need to keep record for their current location, knowing exact number of available packs in the Warehouse and for each client the exact number of currently borrowed packs making Warehouse managing easier and faster.

<img src="https://user-images.githubusercontent.com/90547780/160249626-74cf0927-f37c-472f-aa25-db385cdc67d5.PNG)"width="250" height="250">
# Adding records
Here the user has options to set Date manually if its past date, or let Timestamp() option of the Database autocomplete current date.
Also user may choose number of packs their sending, and enter the number of warehouse paper.
When sending a pack or group of packs, user should pick a status: Y or X , Y- Available in Warehouse and X- Sent by Truck to client.
Buttons for adding a new record/s, clearing the current input and updating existing pack status and location.

<img src="https://user-images.githubusercontent.com/90547780/160249662-96b18962-cec2-468a-8ede-3ef4f1b68762.PNG)"width="250" height="250">
# TableView-embedded H2 Database
Database TableView records with option to apply search filter.
Export to XLS and PDF formats with option to export only currently searched records.
Comment option to describe specific case with specific pack - Records are stored on second by-pass database reachable from mainPage. 
![DatabaseTable](https://user-images.githubusercontent.com/90547780/160249908-43b8231a-a2c2-45d0-88f7-3a11fdc9ef4a.PNG)
# Search filter option
Search filter example
![search](https://user-images.githubusercontent.com/90547780/160249665-ffc9dda7-f5df-4d27-8173-3b037f422e19.PNG)
# Xlsx. Export
Export to XlS
![XLS](https://user-images.githubusercontent.com/90547780/160249673-03b416cd-260e-477b-9e28-49d3f5907338.PNG)
# Table.Xlsx
Table example
![Capture](https://user-images.githubusercontent.com/90547780/160249682-79b69232-f284-44c2-a20b-ae2d9c9a6866.PNG)

