CREATE KEYSPACE IF NOT EXISTS p2plender WITH replication =
{ 'class': 'SimpleStrategy', 'replication_factor' : 1};

--create tables