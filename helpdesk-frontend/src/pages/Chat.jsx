import React, { useEffect, useRef, useState } from "react";
import { Search, MoreVertical, Send, Plus, LogOut } from "lucide-react";
import { Button } from "../components/ui/button";
import { Input } from "../components/ui/input";
import { ScrollArea } from "../components/ui/scroll-area";
import { Separator } from "../components/ui/separator";
import { Avatar, AvatarFallback, AvatarImage } from "../components/ui/avatar";
import MessageBubble from "../components/MessageBubble";
import { sendMessagesToServer } from "../services/chat.service";
import { v4 as v444 } from "uuid";
import { Spinner } from "../components/ui/spinner";
import { useNavigate } from "react-router";
const CHATS = [
  {
    id: 1,
    name: "Spring boot..",
    lastMessage: "How to create rest api in spring boot?",
    unread: 2,
    initials: "SB",
  },
  {
    id: 2,
    name: "React helpers",
    lastMessage: "Can you suggest a hook for this?",
    unread: 0,
    initials: "RH",
  },
  {
    id: 3,
    name: "Database team",
    lastMessage: "Schema migration planned for tonight.",
    unread: 1,
    initials: "DB",
  },
];

const CONVERSATION = [
  {
    id: 1,
    author: "bot",
    text: "Hello! How can I assist you?",
    at: new Date().toLocaleTimeString(),
  },
];

function Chat() {
  const [activeChat, setActiveChat] = useState(CHATS[0]);
  const [messages, setMessages] = useState(CONVERSATION);
  const [draft, setDraft] = useState("");
  const endRef = useRef(null);
  const [sending, setSending] = useState(false);
  const [conversationId, setConversationId] = useState("");
  const inputRef = useRef(null);
  const navigate = useNavigate();
  useEffect(() => {
    const id = v444();
    setConversationId(id);
    inputRef.current.focus();
  }, []);

  useEffect(() => {
    endRef.current?.scrollIntoView({ behavior: "smooth" });
  }, [messages]);

  async function sendMessages() {
    const textMessage = draft.trim();

    if (!textMessage) return;

    setSending(true);

    console.log(draft);

    // console.log(conversationId);

    setMessages((pre) => [
      ...pre,
      {
        id: v444(),
        author: "user",
        text: draft,
        at: new Date().toLocaleTimeString(),
      },
    ]);

    const resposneFromAI = await sendMessagesToServer(draft, conversationId);
    console.log(resposneFromAI);

    setMessages((pre) => [
      ...pre,
      {
        id: v444(),
        author: "bot",
        text: resposneFromAI,
        at: new Date().toLocaleTimeString(),
      },
    ]);

    setSending(false);

    // call api to send messages here

    // setMessages(...)

    setDraft("");
    inputRef.current.focus();
  }

  return (
    <div className="fixed top-0 left-0 right-0  mx-auto min-h-screen max-w-7xl grid grid-cols-1 md:grid-cols-[300px_minmax(0,1fr)] border-x ">
      <div>
        {/* Sidebar */}

        <aside className="hidden md:flex md:flex-col border-r">
          <div className="p-3 flex items-center gap-2">
            <Button size={"icon"} variant={"outline"} className={"h-8 w-8"}>
              <Plus className="h-4 w-4" />
            </Button>
            <div className="relative  w-full">
              <input
                placeholder="Search Chats..."
                type="text"
                className="h-9  w-full pl-8 border rounded"
              />
              <Search className="h-4 w-4  pointer-events-none absolute left-2 top-1/2 -translate-y-1/2 text-muted-foreground" />
            </div>
          </div>
          <Separator />
          <ScrollArea className="flex-1">
            <ul className="p-2 space-y-1">
              {CHATS.map((c) => (
                <li key={c.id}>
                  <button
                    onClick={() => setActiveChat(c)}
                    className={`w-full rounded-xl px-3 py-2 text-left hover:bg-accent transition ${
                      activeChat.id === c.id ? "bg-accent" : ""
                    }`}
                  >
                    <div className="flex items-center gap-3">
                      <Avatar className="h-9 w-9">
                        <AvatarImage src="" alt={c.name} />
                        <AvatarFallback className="text-xs">
                          {c.initials}
                        </AvatarFallback>
                      </Avatar>
                      <div className="min-w-0 flex-1">
                        <div className="flex items-center gap-2">
                          <span className="truncate text-sm font-medium">
                            {c.name}
                          </span>
                          {c.unread ? (
                            <span className="ml-auto inline-flex h-5 min-w-5 items-center justify-center rounded-full bg-primary/10 px-1 text-[10px] font-semibold text-primary">
                              {c.unread}
                            </span>
                          ) : null}
                        </div>
                        <p className="truncate text-xs text-muted-foreground">
                          {c.lastMessage}
                        </p>
                      </div>
                    </div>
                  </button>
                </li>
              ))}
            </ul>
          </ScrollArea>
        </aside>
      </div>
      {/* right chat area */}
      <section className="h-full  border-l">
        {/* Chat Area */}

        {/* header */}

        <div className="flex   items-center justify-between  gap-3 px-4 py-3 border-b">
          <div className="flex gap-3">
            <Avatar>
              <AvatarImage src="" />
              <AvatarFallback className={"text-xs"}>AB</AvatarFallback>
            </Avatar>
            <div className="leading-tight ">
              <div className="text-sm font-medium">Liza Support</div>
              <div className="text-xs text-muted-foreground">
                Online • Typing...
              </div>
            </div>
          </div>

          <div>
            <Button
              onClick={() => {
                navigate("/");
              }}
              variant={"ghost"}
              size={"icon"}
              className={"h-8 w-8"}
            >
              <LogOut className={"h-4 w-3"} />
            </Button>
            <Button variant={"ghost"} size={"icon"} className={"h-8 w-8"}>
              <MoreVertical className={"h-4 w-3"} />
            </Button>
          </div>
        </div>

        {/* chat area */}
        <ScrollArea className={"flex-1 h-[calc(100vh-150px)]"}>
          <div className="mx-auto max-w-3xl px-6   py-6 space-y-6">
            {messages.map((chat, index) => (
              <MessageBubble key={index} author={chat.author} at={chat.at}>
                {chat.text}
              </MessageBubble>
            ))}
          </div>
          <div ref={endRef}></div>
        </ScrollArea>

        {/* composer */}
        <div className="border-t p-3">
          <div className="mx-auto flex max-w-3xl items-center gap-3">
            <Input
              ref={inputRef}
              value={draft}
              onChange={(e) => setDraft(e.target.value)}
              placeholder="Write a message..."
              className={"flex-1 rounded-3x;"}
            />
            <Button
              disabled={sending}
              onClick={sendMessages}
              className={"rounded-2xl px-5"}
            >
              {sending ? <Spinner /> : <Send className="h-4 w-4" />}
              {sending ? "Sending..." : "Send"}
            </Button>
          </div>
        </div>
      </section>
    </div>
  );
}

export default Chat;
