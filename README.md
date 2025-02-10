# PRJ2 - Airline Information System

The purpose of this repository is to document your project work.

***Your group is responsible for the repository structure and content***, but we created some template folders for you. You do not have to stick to this. However make sure everything has a logical place.

## Documentation

GitHub documentation is part of the communication grade for project 2. Therefore it is important to make sure to write proper documentation and to write that in a format that can be rendered by GitHub.
GitHub supports a multitude of languages for this [purpose](git@github.com:FontysVenlo/PRJ2-template.git), however you are only allowed to use:

- [Markdown](https://www.markdownguide.org/) - Have a look at the [GitHub flavored markdown](https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax)
- [AsciiDoc](https://asciidoc-py.github.io/index.html) - Have a look at the [AsciiDoctor cheatsheet](https://docs.asciidoctor.org/asciidoc/latest/syntax-quick-reference/)

## Diagrams

In the AADE course you will learn how to develop diagrams with the use of [Visual Paradigm](https://www.visual-paradigm.com/). You are free to use this program also for the diagrams for project 2.

**However** Visual Paradigm creates `binary` files which don't play nice with version control systems (VCS) such as Git. If using Visual Paradigm to create artefacts, make sure to export to an image format that can be embedded inside your documentation.

We recommend to also have a look at the following ways of creating diagrams, based on text files (which is what VCSs excel at).

- [Mermaid.js](https://mermaid.js.org/): Mermaid diagrams can be directly rendered from Markdown by GitHub, so no need to export diagrams to images and keep them in sync. There are also multiple [VSCode extensions](https://marketplace.visualstudio.com/items?itemName=bierner.markdown-mermaid) available. 
- [PlantUML](https://plantuml.com/) - PlantUml let's you easily create unified modelling languages (UML) diagrams in a text based manner. There is a [VSCode extension available](https://marketplace.visualstudio.com/items?itemName=jebbs.plantuml) for live previews and exporting of diagrams.
- [Diagrams.net](https://app.diagrams.net/) - Drag and drop editor that works in the browser. There is also a [VSCode extension available](https://marketplace.visualstudio.com/items?itemName=hediet.vscode-drawio). By using `.drawio.png` or `.drawio.svg` you can keep the files always in sync, without the need to export.

Examples of these diagrams can be found in the [design](/design) directory.


> [!WARNING]
> Make sure there is always an image available of all diagrams (preferably as SVG)

## Structure

- [Project Management](/project-management) - For all project management related artefacts, e.g. meetings outcomes, retrospectives, screenshots, minutes, planning.
- [Analysis](/analysis) - For all analysis artefacts
- [Design](/design) - For all design artefacts
- [Implementation](/implementation) - For the implementation of the Airline Information System