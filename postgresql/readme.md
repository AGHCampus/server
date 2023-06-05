docker build -t aghcampus-postgres-db . \
docker run --name AGHCampus -p 5432:5432 aghcampus-postgres-db \
docker exec -it AGHCampus psql -U admin aghcampus 