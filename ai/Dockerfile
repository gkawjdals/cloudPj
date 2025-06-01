FROM python:3.10-slim

ENV DEBIAN_FRONTEND=noninteractive

# 기본 작업 디렉토리
WORKDIR /app

# 리포지토리 업데이트 및 패키지 설치
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
        wget curl unzip gnupg ca-certificates \
        chromium chromium-driver \
        default-jdk \
        fonts-liberation libappindicator3-1 libasound2 libatk-bridge2.0-0 libatk1.0-0 libcups2 \
        libdbus-1-3 libgdk-pixbuf2.0-0 libnspr4 libnss3 libx11-xcb1 libxcomposite1 libxdamage1 \
        libxrandr2 xdg-utils libgbm1 libgtk-3-0 \
    && apt-get clean && rm -rf /var/lib/apt/lists/*

# JAVA_HOME 설정
ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
ENV PATH=$JAVA_HOME/bin:$PATH

# requirements 설치
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

# 앱 코드 복사
COPY . .

# 앱 실행
CMD ["python", "app.py"]
