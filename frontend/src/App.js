import React, { useEffect, useState } from "react";
import { getSummaries, postSummary } from "./api";
import { startCrawling } from "./api_flask";

function App() {
  const [summaries, setSummaries] = useState([]);
  const [title, setTitle] = useState("");
  const [summary, setSummary] = useState("");
  const [sourceUrl, setSourceUrl] = useState("");
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    loadData();
  }, []);

  const loadData = async () => {
    const res = await getSummaries();
    setSummaries(res.data);
  };

  const submit = async () => {
    try {
      setLoading(true);             
      await startCrawling();
      await loadData();
      alert("크롤링 완료!");
    } catch (err) {

    } finally {
      setLoading(false);     
    }
  };

  const renderContentAsList = (content) => {
    if (!content) return null;

    const items = content.split(/\d+\.\s/).filter(Boolean);
    return (
      <ol>
        {items.map((item, idx) => (
          <li key={idx}>{item.trim()}</li>
        ))}
      </ol>
    );
  };

  return (
    <div style={{ padding: "2rem" }}>
      <button onClick={submit} disabled={loading}>
        {loading ? "크롤링 중..." : "크롤링 첫 시작 버튼"}
      </button>

      <hr />
      {summaries.map((s) => (
        <div key={s.id} style={{ marginBottom: "1rem" }}>
          <h4>제목 : {s.title}</h4>
          <p>해시태그 : {s.hashtag}</p>
          {renderContentAsList(s.content)}
          <a href={s.org_link} target="_blank" rel="noreferrer">
            원본링크 : {s.org_link}
          </a>
        </div>
      ))}
    </div>
  );
}

export default App;
