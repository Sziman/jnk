FROM python:3.8
WORKDIR /app
COPY . /app
RUN pip requests
CMD ["python3", "tst.py"]
