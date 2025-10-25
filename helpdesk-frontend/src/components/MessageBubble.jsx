import React from "react";

function MessageBubble({ key, author, at, children }) {
  const isMe = author;

  return (
    <div
      className={`flex  ${isMe == "user" ? "justify-end" : "justify-start"}`}
    >
      <div
        className={`max-w-[65%] rounded-2xl px-3 py-2 shadow-sm ${
          isMe == "user"
            ? "bg-slate-900 text-white"
            : "bg-muted text-foreground"
        } `}
      >
        <p className="whitespace-pre-wrap break-words leading-relaxed">
          {children}
        </p>
        <div
          className={`mt-1 text-[10px] ${
            isMe == "user" ? "text-white/70" : "text-muted-foreground"
          }`}
        >
          {at}
        </div>
      </div>
    </div>
  );
}

export default MessageBubble;
