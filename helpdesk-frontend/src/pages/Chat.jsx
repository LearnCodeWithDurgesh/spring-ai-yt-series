import React, { useEffect, useRef, useState } from "react";
import { Search, MoreVertical, Send, Plus } from "lucide-react";
import { Button } from "../components/ui/button";
import { Input } from "../components/ui/input";
import { ScrollArea } from "../components/ui/scroll-area";
import { Separator } from "../components/ui/separator";
import { Avatar, AvatarFallback, AvatarImage } from "../components/ui/avatar";
import MessageBubble from "../components/MessageBubble";

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
  {
    id: 4,
    name: "Design",
    lastMessage: "Updated mockups uploaded to Figma.",
    unread: 3,
    initials: "DE",
  },
  {
    id: 5,
    name: "DevOps",
    lastMessage: "Staging deployment completed successfully.",
    unread: 0,
    initials: "DO",
  },
  {
    id: 6,
    name: "UX Research",
    lastMessage: "Interview slots available next week.",
    unread: 5,
    initials: "UX",
  },
];

const CONVERSATION = [
  {
    id: 1,
    author: "bot",
    text: "Hello! How can I assist you with Spring Boot today?",
    at: "10:00 AM",
  },
  {
    id: 2,
    author: "user",
    text: "Can you help me with the database migration?",
    at: "10:01 AM",
  },
  {
    id: 3,
    author: "bot",
    text: "Ok can you provide me the details of your current database setup?",
    at: "10:03 AM",
  },
];

function Chat() {
  return (
    <div className="mx-auto min-h-screen max-w-7xl grid grid-cols-1 md:grid-cols-[300px_minmax(0,1fr)] border-x ">
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
        </aside>
      </div>
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
            <Button variant={"ghost"} size={"icon"} className={"h-8 w-8"}>
              <Search className={"h-4 w-3"} />
            </Button>
            <Button variant={"ghost"} size={"icon"} className={"h-8 w-8"}>
              <MoreVertical className={"h-4 w-3"} />
            </Button>
          </div>
        </div>

        {/* chat area */}
        <ScrollArea className={"flex-1"}>
          <div className="mx-auto max-w-3xl px-6   py-6 space-y-6">
            {CONVERSATION.map((chat, index) => (
              <MessageBubble key={chat.id} author={chat.author} at={chat.at}>
                {chat.text}
              </MessageBubble>
            ))}
          </div>
        </ScrollArea>

        {/* composer */}
        <div className="border-t p-3">
          <div className="mx-auto flex max-w-3xl items-center gap-3">
            <Input
              placeholder="Write a message..."
              className={"flex-1 rounded-3x;"}
            />
            <Button className={"rounded-2xl px-5"}>
              <Send className=" h-4 w-4" /> <span>Send</span>
            </Button>
          </div>
        </div>
      </section>
    </div>
  );
}

export default Chat;
