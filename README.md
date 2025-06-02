# ☁️ 클라우드 기반 뉴스 요약 웹 서비스

## 📌 프로젝트 개요

- **목표**: 도커(Docker)와 GitHub Actions를 활용해 뉴스 요약 웹 서비스 구축 및 클라우드 배포

- **구성**:
    - React 기반 프론트엔드
    - Spring Boot 기반 백엔드 API 서버
    - Flask 기반 AI 요약 서버 (KoBART + TextRank)
    - PostgreSQL 데이터베이스
    - 1시간 마다 크롤링(개인 작업 스케줄러 등록) or 원할 시에만 크롤링 후 요약
  

- **전체 서비스는 Docker Compose로 통합**, GitHub Actions를 통한 자동 배포(CI/CD) 설정 완료

---

## 🖥️ 사용 방법

### 1. Docker Compose 실행 (로컬 및 서버 공통)

```bash
docker-compose up --build -d
